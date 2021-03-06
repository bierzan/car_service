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
    <form action="/addVehicle" method="post">

        <div class="form-group">
            <label for="vehIdId">ID:</label>
            <input type="number" name="vehId" id="vehIdId" class="form-control" disabled>

            <label for="cliIdId">ID klienta:</label>
            <input type="number" name="cliId" id="cliIdId" class="form-control" value="${param.add}" disabled>

            <label for="brandId">Marka: </label>
            <input type="text" class="form-control" name="brand" id="brandId">

            <label for="modelId">Model: </label>
            <input type="text" class="form-control" name="model" id="modelId">

            <label for="prodYearId">Rok produkcji: </label>
            <input type="number" step="1" min="1900" max="2999" id="prodYearId" class="form-control" name="prodYear">

            <label for="regId">Numer Rejestracyjny:</label>
            <input type="text" name="reg" id="regId" class="form-control">

            <label for="nextServiceId">Następny przegląd: </label>
            <input type="date" id="nextServiceId" class="form-control" name="nextService">
        </div>
        <button class="btn" type="submit" name="sendId" value="${param.add}">Dodaj</button>
    </form>
</div>
<div class="container">

    <%@include file="/footer.jspf" %>
</div>

</body>
</html>
