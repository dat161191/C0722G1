package com.example.controller;

import com.example.model.HinhThucThanhToan;
import com.example.model.ThongTinThueTro;
import com.example.service.IHinhThucThanhToanService;
import com.example.service.IThongTinThueTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ThongTinThueTroController {
    private IHinhThucThanhToanService hinhThucThanhToanService;
    private IThongTinThueTroService thongTinThueTroService;

    @Autowired
    public ThongTinThueTroController(IHinhThucThanhToanService hinhThucThanhToanService, IThongTinThueTroService thongTinThueTroService) {
        this.hinhThucThanhToanService = hinhThucThanhToanService;
        this.thongTinThueTroService = thongTinThueTroService;
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String tnt, @RequestParam(defaultValue = "") String ngay, @RequestParam(defaultValue = "-1") int hinhThucId, @PageableDefault(page = 0, size = 2) Pageable pageable, Model model) {
        if (hinhThucId != -1) {
            HinhThucThanhToan hinhThucThanhToan = hinhThucThanhToanService.findById(hinhThucId);
            Page<ThongTinThueTro> thongTinThueTroList = thongTinThueTroService.findByTenNguoiThueContainingAndNgayThueTroContainsAndHinhThucThanhToans(tnt, ngay, hinhThucThanhToan, pageable);
//            Page<ThongTinThueTro> thongTinThueTroList = thongTinThueTroService.findByTenNguoiThueContainingAndNgayThueTroAndHinhThucThanhToans(tnt, ngay, hinhThucThanhToan, pageable);
            model.addAttribute("thongTinThueTroList", thongTinThueTroList);
        } else {
            Page<ThongTinThueTro> thongTinThueTroList = thongTinThueTroService.findByTenNguoiThueContainingAndNgayThueTroContains(tnt, ngay, pageable);
//            Page<ThongTinThueTro> thongTinThueTroList = thongTinThueTroService.findByTenNguoiThueContainingAndNgayThueTro(tnt, ngay, pageable);
            model.addAttribute("thongTinThueTroList", thongTinThueTroList);
        }
//        model.addAttribute("thanhToan",HinhThucThanhToan.builder().build());
        model.addAttribute("thongTinThueTro", ThongTinThueTro.builder().build());
        model.addAttribute("hinhThucThanhToanList", hinhThucThanhToanService.findAll());
        model.addAttribute("tnt", tnt);
        model.addAttribute("ngay", ngay);
        model.addAttribute("hinhThucId", hinhThucId);
        return "list";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute("thongTinThueTro") ThongTinThueTro thongTinThueTro, RedirectAttributes redirectAttributes){
        thongTinThueTroService.save(thongTinThueTro);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công!!!");
        return "redirect:/";
    }
    @PostMapping("create")
    public String create(@ModelAttribute("thongTinThueTro") ThongTinThueTro thongTinThueTro,RedirectAttributes redirectAttributes){
        thongTinThueTroService.save(thongTinThueTro);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công!!!");
        return "redirect:/";
    }
    @GetMapping("delete")
    public String delete(@RequestParam Integer deleteId, @RequestParam("deleteName2") String deleteName2, RedirectAttributes redirectAttributes) {
        thongTinThueTroService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công!!!");
        return "redirect:/";
    }

}
