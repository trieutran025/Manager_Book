<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trieu
  Date: 7/27/2023
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
    body {
      font-family: Arial, Tahoma;
      font-size: 12px;
    }

    #main {
      width: auto;
      height: auto;
      padding: 0;
      margin-left: auto;
      margin-right: auto;
    }

    #logo {
      height: 100px;
      background-color: #F5F5F5;
      border: 1px solid #CDCDCD;
      margin-bottom: 5px;
    }

    #head-link {
      height: 30px;
      line-height: 30px;
      padding-left: 10px;
      padding-right: 10px;
      border: 1px solid #CDCDCD;
      background-color: #F5F5F5;
      margin-bottom: 5px;
      clear: both;
    }

    #left {
      width: 150px;
      min-height: 500px;
      border: 1px solid #CDCDCD;
      float: left;
      background-color: linen;
      margin-bottom: 5px;

    }

    #content {
      width: 85%;
      min-height: 600px;
      border: 1px solid #CDCDCD;
      float: left;
      margin-left: 5px;
      margin-right: 5px;
      margin-bottom: 5px;
      text-align: center;
    }

    /*#right{*/
    /*    width: 234px;*/
    /*    min-height: 400px;*/
    /*    border: 1px solid #CDCDCD;*/
    /*    float:right;*/
    /*    margin-bottom: 5px;*/
    /*}*/

    #footer {
      height: 10%;
      clear: both;
      border: 1px solid #CDCDCD;
      background-color: #F8F8FF;
    }

    #document_modal {
      font-size: 20px;
    }
  </style>
</head>
<body>
<div id="main">
    <div id="logo">
        <img src="/image/logo.png" width="100px" height="100px">
    </div>
    <%--    <div id="head-link">--%>
    <%--    </div>--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/user">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/book?action=listBook"><h5>Add</h5></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" method="post" action="/user?action=search">

                <input class="form-control mr-sm-2" type="search" placeholder="Search" name="inputChange">
                <input type="hidden" name="action" value="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg>
                </button>
            </form>
        </div>
    </nav>
    <div id="left">
        <%--        <button >--%>
        <%--            <a href="/user?action=add"></a> Add--%>
        <%--        </button>--%>
        <%--        <a href="/user?action=add" class="btn btn-secondary btn-lg disabled" role="button" aria-disabled="true">Add</a>--%>
    </div>
</div>
<div id="content">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Ma Sach</th>
            <th scope="col">Ten Sach</th>
            <th scope="col">Tac gia</th>
            <th scope="col"rowspan="2">Mo ta</th>
            <th scope="col">So luong</th>
            <th scope="col">Ma Sinh Vien</th>
            <th scope="col">Ten Sinh Vien</th>
            <th scope="col">Lop</th>
            <th scope="col">ID muon sach</th>
            <th scope="col">Ma muon Sach</th>
            <th scope="col">Status</th>
            <th scope="col">Ngay Muon</th>
            <th scope="col">Ngay Tra</th>
            <th scope="col"colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <div>
            <form method="post"action="/book">
            <c:forEach items="${cardBooks}" var="bc" varStatus="index">
                <tr>
                    <td>${bc.getBook().getCodeBook()}</td>
                    <td>${bc.getBook().getNameBook()}</td>
                    <td>${bc.getBook().getTacGia()}</td>
                    <td>${bc.getBook().getMoTa()}</td>
                    <td>${bc.getBook().getQuantity()}</td>
                    <td>${bc.getStudent().getCodeStudent()}</td>
                    <td>${bc.getStudent().getNameStudent()}</td>
                    <td>${bc.getStudent().getClassStudent()}</td>
                    <td>${bc.idCardBook}</td>
                    <td>${bc.codeCardBook}</td>
                    <td>${bc.status}</td>
                    <td>${bc.dateMuon}</td>
                    <td>${bc.dateTra}</td>
                    <td><input type="checkbox" name="idRemove" value="${bc.idCardBook}"></td>
                    <td><input type="hidden"name="action"value="delete"></td>
                </tr>
            </c:forEach>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete User</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div id="document_modal">
                        Bạn có xác nhận xóa
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" formtarget="_blank">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    </form>

        </div>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Remove All
    </button>



    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
