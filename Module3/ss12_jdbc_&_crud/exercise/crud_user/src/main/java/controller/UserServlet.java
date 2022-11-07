package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private final IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showSaveUser(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "remove":
                showRemoveUser(request, response);
                break;
//            case "detail":
//                showDetailProduct(request, response);
//                break;
            default:
                showUserList(request, response);
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findByID(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("view/user/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showRemoveUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSaveUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/user/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                save(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "find":
                findUser(request,response);
//            case "remove":
//                removeProduct(request, response);
//                break;
        }
    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) {
        String country=request.getParameter("country");
        List<User> userList=userService.findByCountry(country);
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = userService.update(id,user);
        String mess = "Sửa không thành công";
        if (check) {
            mess = "Sửa thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/user/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        //Lấy thuộc tính là dữ liệu từ người dùng nhập vào
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        //Tạo đối tượng mới vs các thuộc tính người dùng nhập vào
        User user = new User(name, email, country);
        //Thực hiện thêm mới đối tượng vào list,nếu thêm thành công thì trả về true
        boolean check = userService.add(user);
        //Tạo 1 chuỗi thông báo khi thêm mới thành công hay không;
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
