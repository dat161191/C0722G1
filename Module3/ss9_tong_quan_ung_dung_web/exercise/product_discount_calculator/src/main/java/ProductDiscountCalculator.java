import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDiscountCalculator", value = "/discount")
public class ProductDiscountCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double prince = Double.parseDouble(request.getParameter("prince"));
        double percent = Double.parseDouble(request.getParameter("percent"));
        double amount = prince * percent * 0.01;
        double princeAfter=prince-amount;
        request.setAttribute("luong_chiet_khau",amount);
        request.setAttribute("gia_sau_chiet_khau",princeAfter);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
