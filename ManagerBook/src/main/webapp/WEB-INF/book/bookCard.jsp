<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/user">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<form method="post" action="/book?action=muon">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputIDCardbook">id the muon Sach</label>
            <input type="text" class="form-control" id="inputIDCardbook" placeholder="ID" name="idCard">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCodeCardbook">id the muon Sach</label>
            <input type="text" class="form-control" id="inputCodeCardbook" placeholder="ID" name="codeCard">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputID">Ma  Sach</label>
            <input type="text" class="form-control" id="inputID" placeholder="ID" name="idBook"
                   value="${book.getIdBook()}"
                   readonly>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputName"> Ten Sach</label>
            <input type="text" class="form-control" id="inputName" placeholder="idBook" name="name"
                   value="${book.getNameBook()}" readonly>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCode">Ten Hoc Sinh</label>
            <%--            <input type="s" class="form-control" id="inputCode" placeholder="nameHS" name="quantity">--%>
            <select name="idStudent">
                <c:forEach items="${students}" var="s">
                    <option value="${s.idStudent}" id="inputCode">${s.nameStudent}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputDateTra">Ngay Tra Sach</label>
            <input type="date" class="form-control" id="inputDateTra" placeholder="price" name="ngayTra">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <input type="hidden" name="action" value="muon">
                <input type="submit" value="Muon">
                <a href="/book?action=listBook">Huy</a>
            </div>
        </div>
    </div>
</form>
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
