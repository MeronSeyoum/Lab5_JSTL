package ca.sait.lab5_jstl.Servlet;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Meron seyoum
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
        // it enable user to register and login to shopping list as well as redirect back to home page after logout      
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
// request for httpsession       
        HttpSession session = request.getSession();

        String actions = request.getParameter("action");
//display user name and avaliable session for list 
        if (actions.equals("register")) {
            String username = request.getParameter("username");

            if (username == null || username.isEmpty()) {

                request.setAttribute("message", "Username is missing.");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else {
                ArrayList<String> items = new ArrayList<>();
                session.setAttribute("username", username);
                session.setAttribute("items", items);
            }
        } //if request is add, add list to the session and shopping page list
        else if (actions.equals("add")) {

            String item = request.getParameter("list");
            ArrayList items = (ArrayList<String>) session.getAttribute("items");

            items.add(item);
            session.setAttribute("items", items);
        } // delete selected list item from the page and session
        else if (actions.equals("delete")) {

            String item = request.getParameter("list");
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

            items.remove(item);
            session.setAttribute("items", items);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
