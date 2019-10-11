<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--Color Palette: https://colorhunt.co/palette/117601-->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
      crossorigin="anonymous"
      />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>Manage Users</title>
    <style>
      body {
        height: 100vh;
        background: #232931;
      }
      .navbar {
        grid-area: header;
        height: 4rem;
      }
      .main {
        margin: auto;
        padding-top: 1rem;
        width: 60%;
        background: #393e46;
        color: #eeeeee;
        max-height: calc(100vh - 4rem);
        overflow-y: auto;
      }
      .row-btn {
        padding: 0;
        min-width: 35px;
      }
      .user-add-form {
        display: flex;
        margin: auto;
      }
      .user-add-form input {
        border-style: solid;
        border-width: 1px;
        margin: 0 !important;
        width: 30%;
        padding: 5px;
      }
      .user-add-form input:last-child {
        width: 10%;
      }
    </style>
  </head>
  <body>
    <div class="page">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Inventory Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
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
