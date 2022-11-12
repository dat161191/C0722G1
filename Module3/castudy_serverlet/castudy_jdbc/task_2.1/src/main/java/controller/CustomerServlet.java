package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
//            case "remove":    DÙNG MODAL KHÔNG CÓ PHƯƠNG THỨC GET
//                showRemoveUser(request, response);
//                break;
            default:
                showCustomerList(request, response);
        }

    }

    /*========== EDIT GET=============*/
    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findByID(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    /*=============== ADD GET===============*/
    private void showAddCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    /*============= DISPLAY ============*/
    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
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
                addCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "remove":
                removeCustomer(request, response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
        }
    }


/*================== EDIT POST==================*/
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        Customer customerEdit = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId);
        boolean check = customerService.editCustomer(id,customerEdit);
        String mess = "Cập nhật không thành công";
        if (check) {
            mess = "Cập nhật thành công";
        }
        request.setAttribute("mess", mess);
        showCustomerList(request,response);
    }

    /*=========== SEARCH BY ID============*/
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Customer> customerList = customerService.searchByNameAndAdrress(name);
        request.setAttribute("customerList", customerList);
        request.setAttribute("search", name);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /*============= REMOVE ===============*/
    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = customerService.removeCustomer(id);
        String mess = "Xóa không thành công";
        if (check) {
            mess = "Xóa thành công";
        }
        request.setAttribute("mess", mess);
        showCustomerList(request, response);
    }


    /*=============== ADD==================*/
    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        Customer customer = new Customer(name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId);
        boolean check = customerService.addCustomer(customer);
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
