package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hazco
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String action = request.getParameter();*/
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user_name = request.getParameter("user");
        String passwrd = request.getParameter("password");
        
        //validation
        if(user_name == null || user_name.equals("") || passwrd == null || passwrd.equals("")){
                request.setAttribute("message", "Please fill username and password.");
                return;
            }
        
    }

}
