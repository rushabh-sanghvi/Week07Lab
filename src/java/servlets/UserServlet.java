package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    String action = request.getParameter("action");
    action = action == null ? "" : action;

    String[] values = new String[]{fname, lname, email};

    if (!checkFalsey(values)) {
      response.sendRedirect("users");
      return;
    }

    switch (action) {
            case "add": {
                try {
                    us.insert(new User(email, fname, lname, password));
                    request.setAttribute("users", us.getAll());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
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
