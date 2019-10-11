<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--Color Palette: https://colorhunt.co/palette/117601-->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Users</title>
    <link 
      rel="stylesheet" 
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
      crossorigin="anonymous"
      />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
      crossorigin="anonymous"
      />
    <link href="/css/users.css" rel="stylesheet">
  </head>
  <body>
    <div class="page">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Inventory Management</a>

        <ul class="navbar-nav ml-auto">
          <a class="nav-link" href="/">Home</a>
        </ul>
      </nav>

      <div class="main">
        <h2 class="text-center">Manage Users</h2>
        <form class="user-add-form">
          <input 
            class="mb-3 bg-dark text-light border-secondary" 
            type="email" 
            name="email" 
            placeholder="Email"
            />
          <input 
            class="mb-3 bg-dark text-light border-secondary" 
            type="text" 
            name="fname" 
            placeholder="First Name"
            />
          <input 
            class="mb-3 bg-dark text-light border-secondary" 
            type="text" 
            name="lname" 
            placeholder="Last Name"
            />
          <input class="btn-primary" type="button" value="Save"/>
        </form>
        <table class="table table-dark">
          <thead>
            <tr>
              <th>Email</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th class="text-center">Edit</th>
              <th class="text-center">Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>test Email</td>
              <td>Test fName</td>
              <td>Test lName</td>
              <td class="text-center">
                <a href="#" class="btn row-btn">
                  <i class="text-secondary fas fa-pencil-alt"></i>
                </a>
              </td>
              <td class="text-center">
                <a href="#" class="btn row-btn">
                  <i class="text-danger fas fa-times" ></i>
                </a>
              </td>
            </tr>
            <tr>
              <c:forEach items="${users}" var="user">
                <td>${user.email}</td>
                <td>${user.fname}</td>
                <td>${user.lname}</td>
                <td><a href="#" class="row-btn">Edit</a></td>
                <td><a href="#" class="row-btn">Delete</a></td>
              </c:forEach>
              <c:if test="${users eq null}">
                <td class="text-center" colspan="5"><h5>No Users Found</h5></td>
              </c:if>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
