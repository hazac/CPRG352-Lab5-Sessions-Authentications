package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author hazco
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout") == null){
            if(session.getAttribute("user") != null){
                request.setAttribute("message", "Hello " + session.getAttribute("user") + ".");
                response.sendRedirect("home");           
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            //return;
        }
        else{
            //Log out = invalidate session, set message to successful logout
            //HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get parameters from login form
        String user_name = request.getParameter("user");
        String passwrd = request.getParameter("password");
        AccountService account = new AccountService();
        
        //validation user and password are not empty
        if(user_name == null || user_name.equals("") || passwrd == null || passwrd.equals("")){
            request.setAttribute("user", user_name);
            request.setAttribute("password", passwrd);
            request.setAttribute("message", "Login credentials are not valid.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
            }
        else{
            //authentication using AccountServices's login()
            User user = account.login(user_name, passwrd);
            if (user == null){
                request.setAttribute("user", user_name);
                request.setAttribute("password", passwrd);
                request.setAttribute("message", "Login credentials are not valid.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            else{
                //user object successfully created, create session and redirect to home
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getUsername());
                response.sendRedirect("home");
                return;
            }                    
        }        
    }

}
