package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

public class UserServlet extends HttpServlet {

    /**
     * The doGet method in UserServlet, which works with users.jsp
     *
     * @param request request
     * @param response response
     * @throws ServletException Servlet Exception
     * @throws IOException Input/Output Exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "clearEdit":
                request.setAttribute("edit", true);
                request.setAttribute("user", null);
                break;
            case "edit": {
                if (checkFalsey(new String[]{email})) {
                    request.setAttribute("edit", true);
                    try {
                        request.setAttribute("user", us.get(email));
                    } catch (Exception e) {
                        request.setAttribute("error", "Could not retrieve user.");
                    }
                } else {
                    request.setAttribute("error", "Could not retrieve user.");
                    return;
                }
                break;
            }
            case "delete":
                if (checkFalsey(new String[]{email})) {
                    try {
                        us.delete(email);
                    } catch (Exception e) {
                        request.setAttribute("error", "Could not delete user.");
                    }
                } else {
                    request.setAttribute("error", "Could not delete user.");
                    return;
                }
                break;
        }

        try {
            request.setAttribute("users", us.getAll());
        } catch (Exception e) {
            request.setAttribute("error", "Could not retrive users.");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    /**
     * The doPost method in UserServlet, which works with users.jsp
     *
     * @param request request
     * @param response response
     * @throws ServletException Servlet Exception
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "add": {
                String emailAdd = request.getParameter("emailAdd");
                String fnameAdd = request.getParameter("fnameAdd");
                String lnameAdd = request.getParameter("lnameAdd");
                String passwordAdd = request.getParameter("passwordAdd");

                String[] values = new String[]{emailAdd, fnameAdd, lnameAdd, passwordAdd};

                if (!checkFalsey(values)) {
                    response.sendRedirect("users");
                    return;
                }

                try {
                    us.insert(new User(values[0], values[1], values[2], values[3]));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            case "edit": {
                String emailEdit = request.getParameter("emailEdit");
                String fnameEdit = request.getParameter("fnameEdit");
                String lnameEdit = request.getParameter("lnameEdit");

                String[] values = new String[]{emailEdit, fnameEdit, lnameEdit};

                if (!checkFalsey(values)) {
                    response.sendRedirect("users");
                    return;
                }

                try {
                    us.update(new User(values[0], values[1], values[2], "password"));
                } catch (Exception ex) {
                    request.setAttribute("errorMsg", ex.getMessage());
                }
            }
        }

        try {
            request.setAttribute("users", us.getAll());
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    private boolean checkFalsey(String[] values) {
        // check each elemenet in array for null or empty string
        // return false if one is found
        for (String s : values) {
            if (s == null || s.equals("")) {
                return false;
            }
        }
        return true;
    }
}
