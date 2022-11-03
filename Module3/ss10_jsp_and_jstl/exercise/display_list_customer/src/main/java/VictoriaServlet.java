import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VictoriaServlet", value = "/Victoria")
public class VictoriaServlet extends HttpServlet {
    private static List<Victoria> victoriaList = new ArrayList<>();

    static {
        victoriaList.add(new Victoria("Candice Swanepoel", "03/ 07/ 1993", "Úc", "https://toplist.vn/images/800px/candice-swanepoel-218335.jpg"));
        victoriaList.add(new Victoria("Laetitia Casta", "20/ 12/ 1985", "Pháp", "https://toplist.vn/images/800px/laetitia-casta-218333.jpg"));
        victoriaList.add(new Victoria("Heidie Klum", "01/ 04/ 1985", "Đức", "https://toplist.vn/images/800px/heidie-klum-217719.jpg"));
        victoriaList.add(new Victoria("Alessandra Ambrosio", "12/ 06/ 1981", "Brazil", "https://toplist.vn/images/800px/alessandra-ambrosio-218337.jpg"));
        victoriaList.add(new Victoria("Miranda Kerr", "20/ 04/ 1983", "Úc", "https://toplist.vn/images/800px/miranda-kerr-218336.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("victoriaList", victoriaList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
