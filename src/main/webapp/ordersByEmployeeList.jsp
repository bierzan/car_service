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
    <%@include file="header.jspf" %>
</div>
<div class="container-fluid">
    <table class="table table-sm table-condensed table-hover" style="font-size: 90%">
        <tr>
            <th>ID</th>
            <th>DATA PRZYJĘCIA</th>
            <th>DATA ROZPOCZĘCIA PRACY</th>
            <th>OPIS PROBLEMU</th>
            <th>OPIS NAPRAWY</th>
            <th>STATUS ZLECENIA</th>
            <th>ID POJAZDU</th>
            <th>KOSZT NAPRAWY</th>
            <th>KOSZT CZĘŚCI</th>
            <th>RG</th>
        </tr>
        <c:forEach items="${orders}" var="ord">
            <tr>
                <td>${ord.id}</td>
                <td>${ord.orderDate}</td>
                <td>${ord.repairStart}</td>
                <td>${ord.problemDescription}</td>
                <td>${ord.repairDescription}</td>
                <td>${ord.status.displayStatus}</td>
                <td>${ord.vehicle.id}</td>
                <td>${ord.repairCost}</td>
                <td>${ord.partsCost}</td>
                <td>${ord.workingHours}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">

    <%@include file="footer.jspf" %>
</div>

</body>
</html>
