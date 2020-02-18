<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Advertisment list by the city</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <style>
        ul {
            margin: 25px;
            padding: 0px;
            width: 200px;
            height: 220px; /* Размеры */
            outline: 2px solid #000; /* Чёрная рамка */
            border-radius: 10px; /* Радиус скругления */
        }
    </style>

</head>
<body>
<h2>Here you can see the advertisments by the current city</h2>>


<div align="center">
    <c:forEach var="advertisment" items="${list_by_city}">
        <ul>
            <li><c:out value="ID: "/>
                <c:out value="${advertisment.id}"/></li>

            <li><c:out value="Title: "/>
                <c:out value="${advertisment.title}"/></li>

            <li><c:out value="Apartment type: "/>
                <c:out value="${advertisment.apartment_type}"/></li>

            <li><c:out value="City: "/>
                <c:out value="${advertisment.city}"/></li>

            <li><c:out value="Address: "/>
                <c:out value="${advertisment.address}"/></li>

            <li><c:out value="Description: "/><br>
                <c:out value="${advertisment.description}"/></li>

            <li><c:out value="Since: "/>
                <c:out value="${advertisment.since}"/></li>

            <li><c:out value="Till: "/>
                <c:out value="${advertisment.till}"/></li>

            <li><c:out value="The author is "/>
                <c:out value="${advertisment.user.username}"/></li>

            <li><c:out value="Apartment photo"/>
                <c:out value="${advertisment.image}"/></li>

            <li><a href="/edit_advertisment?id=${advertisment.id}">Edit</a>

                <a href="/delete_advertisment?id=${advertisment.id}">Delete</a></li>
        </ul>
    </c:forEach>

</div>

<div align="center">
    <a href="/welcome">Back to welcome</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>