<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Title</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <style>
        ul {
            align: "center";
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

<div>

    <form:form method="POST" modelAttribute="reservation" action="/book_advertisment" class="adv-form">

        <h4 class="adv-form-heading">Make your reservation on current adv</h4>

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
                <c:out value="${advertisment.since}" /></li>

            <li><c:out value="Till: "/>
                <c:out value="${advertisment.till}" /></li>

            <li><c:out value="The author is "/>
                <c:out value="${advertisment.user.username}"/>
                <c:out value="${advertisment.user.id}"/></li>

            <%--<li><c:out value="Apartment photo"/>--%>
                <%--<c:out value="${advertisment.image}"/></li>--%>
        </ul>

        <spring:bind path="advertisment"><form:input type="hidden" path="advertisment" value="${advertisment.id}" /></spring:bind>

        <spring:bind path="host"><form:input type="hidden" path="host" value="${advertisment.user.id}" /></spring:bind>

        <spring:bind path="reservetion_since"><div><form:input type="date" path="reservetion_since" /></div></spring:bind>

        <spring:bind path="reservetion_till"><div><form:input type="date" path="reservetion_till"/></div></spring:bind>
        <button type="submit">Submit</button>
    </form:form>

</div>


<div align="center">
    <a href="/welcome">Back to welcome</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>


</body>

</html>