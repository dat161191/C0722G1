package com.example.controller;

import com.example.model.Book;
import com.example.model.OderBook;
import com.example.service.IBookService;
import com.example.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class OderBookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IOderBookService iOderBookService;

    @GetMapping("/book")
    public String listBook(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "/book/list";
    }

    @GetMapping("/{id}/oder")
    public String showFormOder(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/book/oder";
    }

    @PostMapping("/oder")
    public String saveOder(@ModelAttribute(value = "book") Book book, RedirectAttributes redirectAttributes) {
        if (book.getQuantity() > 0) {
            OderBook oderBook = new OderBook();
            Long bookRentalCode = (long) (Math.random() * (99999 - 10000) + 10000);
            oderBook.setBookRentalCode(bookRentalCode);
            oderBook.setBook(book);
            iOderBookService.saveOder(oderBook);
            int quantity = book.getQuantity() - 1;
            book.setQuantity(quantity);
            iBookService.saveBook(book);
            redirectAttributes.addFlashAttribute("mess", "Oder Success!!! Book rental code is: " + bookRentalCode);
            return "redirect:/book";
        }
        else {
            redirectAttributes.addFlashAttribute("mess", "Oder Not Success!!");
            return "redirect:/book";
        }
    }

    @GetMapping("/pay")
    public String showFormReturnBook(Model model) {
        model.addAttribute("oderBook", new OderBook());
        return "/book/pay";
    }

    @PostMapping("/pay")
    public String saveReturn(@ModelAttribute(value = "oderBook") OderBook oderBook, RedirectAttributes redirectAttributes) {
        OderBook oderBookReturn = iOderBookService.findByBookRentalCode(oderBook.getBookRentalCode());
        if (oderBookReturn != null) {
            Book book = iBookService.findById(oderBookReturn.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);
            iBookService.saveBook(book);
            oderBookReturn.setBookRentalCode((long) 0);
            iOderBookService.saveOder(oderBookReturn);
            redirectAttributes.addFlashAttribute("mess", "Pay Success!");
            return "redirect:/book";
        } else {
            redirectAttributes.addFlashAttribute("mess", "Pay Not Success!wrong code!");
            return "redirect:/pay";
        }
    }
}
