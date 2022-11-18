package controller;

import model.PhongTro;
import service.IPhongTroService;
import service.impl.PhongTroService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongTroServlet", value = "/phongtro")
public class PhongTroServlet extends HttpServlet {
    private IPhongTroService phongTroService = new PhongTroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAdd(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    /*============== EDIT DOGET===============*/
    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int maPhongTro = Integer.parseInt(request.getParameter("maPhongTro"));
        PhongTro phongTro = phongTroService.findByID(maPhongTro);
        request.setAttribute("phongTro", phongTro);
        try {
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*==============ADD DOGET=============*/
    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /*===========SHOWLIST====================*/
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addPt(request, response);
                break;
            case "edit":
                editPt(request, response);
                break;
            case "remove":
                removePt(request, response);
                break;
            case "search":
                searchPt(request, response);
                break;
        }
    }

    /*==========SEARCH================*/
    private void searchPt(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String tenHinhThuc = request.getParameter("tenHinhThuc");

                /*Search nhiều trường 1 ô:
      List<PhongTro> phongTroList = phongTroService.search(ten);    */

        /* Search nhiều trường nhiểu ô*/
        List<PhongTro> phongTroList = phongTroService.search(ten, sdt, tenHinhThuc);
        request.setAttribute("phongTroList", phongTroList);
        request.setAttribute("ten", ten);
        request.setAttribute("sdt", sdt);
        request.setAttribute("tenHinhThuc", tenHinhThuc);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /*===========REMOVE DOPOST=========*/
    private void removePt(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = phongTroService.remove(id);
        String mess = "Xóa không thành công";
        if (check) {
            mess = "Xóa thành công";
        }
        request.setAttribute("mess", mess);
        showList(request, response);
    }

    /*===============EDIT DOPOST=============*/
    private void editPt(HttpServletRequest request, HttpServletResponse response) {
        int maPhongTro = Integer.parseInt(request.getParameter("maPhongTro"));
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String ngayThue = request.getParameter("ngayThue");
        String ghiChu = request.getParameter("ghiChu");
        String email = request.getParameter("email");
        int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
        PhongTro phongTro = new PhongTro(maPhongTro, ten, sdt, ngayThue, ghiChu, email, maThanhToan);
        boolean check = phongTroService.edit(maPhongTro, phongTro);
        String mess = "Cập nhật không thành công";
        if (check) {
            mess = "Cập nhật thành công";
        }
        request.setAttribute("mess", mess);
        showList(request, response);

    }

    /*==================ADD DOPOST=============*/
    private void addPt(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String ngayThue = request.getParameter("ngayThue");
        String ghiChu = request.getParameter("ghiChu");
        String email = request.getParameter("email");
        int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
        PhongTro phongTro = new PhongTro(ten, sdt, ngayThue, ghiChu,email,maThanhToan);
        boolean check = phongTroService.add(phongTro);
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);

        /*---Nhảy trang*/
        try {
            request.getRequestDispatcher("/view/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

        /*Modal*/
        showList(request,response);
    }

}
