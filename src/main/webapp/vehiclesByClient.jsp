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
    <form action="/forms/addVehicle.jsp" method="post">
        <button type="submit" name="add" class="btn btn-primary btn-block" value="${client}">Dodaj pojazd</button>
    </form>
</div>
<div class="container">
    <table class="table table-sm table-condensed table-hover" style="font-size: 90%">
        <tr>
            <th>ID</th>
            <th>MARKA</th>
            <th>MODEL</th>
            <th>ROK PRODUKCJI</th>
            <th>NR REJ.</th>
            <th>NASTĘPNY SERWIS</th>
        </tr>
        <c:forEach items="${vehicles}" var="veh">
            <tr>

                <td>${veh.id}</td>
                <td>${veh.brand}</td>
                <td>${veh.model}</td>
                <td>${veh.productionYear}</td>
                <td>${veh.regNumber}</td>
                <td>${veh.nextService}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">

    <%@include file="footer.jspf" %>
</div>

</body>
</html>
