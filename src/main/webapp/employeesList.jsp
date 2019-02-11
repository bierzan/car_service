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

<div class="container">
    <form action="/forms/addEmployee.jsp">
        <button type="submit" class="btn btn-primary btn-block">Dodaj pracownika</button>
    </form>
</div>
<div class="container-fluid">
    <table class="table table-sm table-condensed table-hover" style="font-size: 90%">
        <tr>
            <th>ID</th>
            <th>IMIĘ</th>
            <th>NAZWISKO</th>
            <th>ADRES</th>
            <th>NR TEL.</th>
            <th style="width:50%">NOTATKA</th>
            <th>RG</th>
            <th></th>
            <th></th>
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
                <td><a href="/EmployeeOrders?empId=${emp.id}">Zlecenia</a></td>
                <td><a href="/employeeToEdit?empId=${emp.id}">Edytuj</a></td>
                <td><a href="/deleteEmployee?empId=${emp.id}">Usuń</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">

    <%@include file="footer.jspf" %>
</div>

</body>
</html>
