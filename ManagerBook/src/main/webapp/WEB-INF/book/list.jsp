<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
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
                    <a class="nav-link" href="/product?action=add"><h5>Add</h5></a>
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
            <th scope="col">#</th>
            <th scope="col">ID Sach</th>
            <th scope="col">Ma Sach</th>
            <th scope="col">Ten Sach</th>
            <th scope="col">Tac gia</th>
            <th scope="col">Mo ta</th>
            <th scope="col">So luong</th>
            <th scope="col" colspan="2">action</th>
        </tr>
        </thead>
        <tbody>
        <div>
            <c:forEach items="${books}" var="b" varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${b.idBook}</td>
                    <td>${b.codeBook}</td>
                    <td>${b.nameBook}</td>
                    <td>${b.tacGia}</td>
                    <td>${b.moTa}</td>
                    <td>${b.quantity}</td>
                    <td><label>
                        <a href="<c:url value="/book?action=muon&id=${b.idBook}"/>">Muon</a>
                    </label>
                </tr>
            </c:forEach>

        </div>
        </tbody>
    </table>


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
</body>
</html>
