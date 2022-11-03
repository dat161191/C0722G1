import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calulator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("num1"));
        float secondOperand = Float.parseFloat(request.getParameter("num2"));
        char operator = request.getParameter("Operator").charAt(0);
        float result =Calculator.calculate(firstOperand,secondOperand,operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
