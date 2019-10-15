package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

public class UserServlet extends HttpServlet {

  /**
   * The doGet method in UserServlet, which works with users.jsp
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
        String[] values = new String[3];
        values[0] = fname;
        values[1] = lname;
        values[2] = email;
        if (!checkFalsey(values)) {
          response.sendRedirect("users");
          return;
        }
        request.setAttribute("edit", true);
        try {
          request.setAttribute("user", us.get(email));
        } catch (Exception e) {
          request.setAttribute("error", "Could not retrieve user.");
        }
        break;
      }
      case "delete":
        try {
          us.delete(email);
        } catch (Exception e) {
          request.setAttribute("error", "Could not delete user.");
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
   * @param request request
   * @param response response
   * @throws ServletException Servlet Exception
   * @throws IOException  IOException
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

    String[] values = new String[3];
    values[0] = fname;
    values[1] = lname;
    values[2] = email;

    if (!checkFalsey(values)) {
      response.sendRedirect("users");
      return;
    }

    switch (action) {
      case "add": {
        
      }
    }
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
