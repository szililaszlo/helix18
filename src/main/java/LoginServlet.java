import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html)");
        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("name");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("admin")) {


            req.getRequestDispatcher("profile.html").include(req,resp);
            printWriter.write("<h1>Welcome: "+ username +"</h1");
        }
        else {
            printWriter.write("<h1>Rossz a jelszó! </h1");
            req.getRequestDispatcher("login.html").include(req,resp);
        }
        printWriter.close();
    }
}
