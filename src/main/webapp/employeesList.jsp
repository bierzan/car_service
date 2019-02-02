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
    <table class="table table-sm table-condensed" style="font-size: 14px">
        <tr>
            <th>ID</th>
            <th>IMIĘ</th>
            <th>NAZWISKO</th>
            <th>ADRES</th>
            <th>NR TEL.</th>
            <th>NOTATKA</th>
            <th>RG</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.address}</td>
                <td>${emp.phone}</td>
                <td>${emp.note}</td>
                <td>${emp.workingHourCost}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">

    <%@include file="footer.jspf" %>
</div>

</body>
</html>
