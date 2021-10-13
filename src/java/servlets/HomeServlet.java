
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //get session 
        HttpSession session =  request.getSession();
        
        //check if there is a valid session then sends the user to the home page
        if(session.getAttribute("user") != null){
            request.setAttribute("message", "Hello " + session.getAttribute("user") + ".");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);    
            return;
        }
        //if the session is not valid redirects the user to login
        else{
            response.sendRedirect("login");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
