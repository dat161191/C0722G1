package controller;

import model.BenhNhan;
import service.IBenhNhanService;
import service.impl.BenhNhanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/*-----------NHỚ ĐỔI VALUE /test-------------*/
@WebServlet(name = "TestServlet", value = "/benhNhan")
public class BenhNhanServlet extends HttpServlet {
    private IBenhNhanService benhNhanService = new BenhNhanService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhNhan> benhNhanList=benhNhanService.findAll();
        request.setAttribute("benhNhanList",benhNhanList);
        try {
            request.getRequestDispatcher("/view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "remove":
                showRemove(request, response);
                break;
        }
    }

    private void showRemove(HttpServletRequest request, HttpServletResponse response) {
        String maBenhAn =(request.getParameter("id"));
        boolean check = benhNhanService.remove(maBenhAn);
        String mess = "Xóa không thành công";
        if (check) {
            mess = "Xóa thành công";
        }
        request.setAttribute("mess", mess);
        showList(request, response);
    }
}
