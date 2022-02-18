package ca.sait.lab5_jstl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author merya
 */
public class ShoppingListServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handles creation/destruction of sessions        
        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            String query = request.getQueryString();

            if (query != null && query.contains("logout")) {
                session.invalidate();
                request.setAttribute("message", "User has successfully logged out.");
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String actionValue = request.getParameter("action");

        if (actionValue.equals("register")) {
            String username = request.getParameter("username");

            if (username == null || username.isEmpty()) {
                
          request.setAttribute("message", "Username is missing.");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);  
} else {
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");

            }

        }
    }
}
