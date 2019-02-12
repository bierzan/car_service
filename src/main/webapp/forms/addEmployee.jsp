<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CAR SERVICE</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%@include file="/header.jspf" %>
</div>
<div class="container">
    <form action="/addEmployee" method="post">

        <div class="form-group">
            <label for="empIdId">ID:</label>
            <input type="number" name="empId" id="empIdId" class="form-control" disabled>

            <label for="nameId">Imię: </label>
            <input type="text" class="form-control" name="name" id="nameId">

            <label for="surnameId">Nazwisko: </label>
            <input type="text" class="form-control" name="surname" id="surnameId">

            <label for="addressId">Adres: </label>
            <textarea id="addressId" class="form-control" name="address"></textarea>

            <label for="phoneId">Telefon:</label>
            <input type="number" name="phone" id="phoneId" max="9999999999" class="form-control">

            <label for="noteId">Notatka: </label>
            <textarea id="noteId" class="form-control" name="note"></textarea>

            <label for="whcId">Koszt roboczogodziny:</label>
            <input type="number" step="0.01" name="whc" id="whcId" class="form-control">
        </div>
        <button class="btn" type="submit" name="sendId">Dodaj</button>
    </form>
</div>
<div class="container">

    <%@include file="/footer.jspf" %>
</div>

</body>
</html>
