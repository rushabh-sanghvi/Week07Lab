package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

public class UserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    String action = request.getParameter("action");
    action = action == null ? "" : action;

    switch (action) {
      case "edit": {
        if (fname == null || fname.equals("")
                || lname == null || lname.equals("")
                || email == null || email.equals("")) {
          response.sendRedirect("users");
          return;
        }
        User userToEdit = new User(email, fname, lname, "password");
        request.setAttribute("edit", true);
        request.setAttribute("user", userToEdit);
        break;
      }

    }

    getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }
}
