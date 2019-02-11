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
    <form action="/UpdateClient" method="post">

        <div class="form-group">
            <label for="cliIdId">ID:</label>
            <input type="number" name="cliId" id="cliIdId" value="${client.id}" class="form-control" disabled>

            <label for="nameId">Imię: </label>
            <input type="text" class="form-control" name="name" id="nameId" value="${client.name}">

            <label for="surnameId" >Nazwisko: </label>
            <input type="text" class="form-control" name="surname" id="surnameId" value="${client.surname}">

            <label for="birthdayId">Data urodzenia: </label>
            <input type="date" id="birthdayId" class="form-control" name="birthday" value="${client.birthday}">
        </div>
        <button class="btn" type="submit" name="sendId" value="${client.id}">Zaktualizuj</button>
    </form>
</div>
<div class="container">

    <%@include file="/footer.jspf" %>
</div>

</body>
</html>
