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

</head>

<body>

<div>

    <form:form method="POST" modelAttribute="adv" action="/add_new_adv" class="adv-form">

        <h4 class="adv-form-heading">Input dates for the reservation</h4>

        <spring:bind path="title"><div><form:input type="text" path="title" class="form-control" placeholder="Title"/></div></spring:bind>

        <spring:bind path="apartment_type"><div>Here choose the type of your apartment

            <form:select path="apartment_type">
                <form:option value="" label="Choose"/>
                <form:options items="${availableOptions}"/>
            </form:select></div></spring:bind>

        <spring:bind path="city"><div><form:input type="text" path="city" class="form-control" placeholder="City"/></div></spring:bind>

        <spring:bind path="address"><div><form:input type="text" path="address" class="form-control" placeholder="Address"/></div></spring:bind>

        <spring:bind path="description"><div><form:input type="text" path="description" class="form-control" placeholder="Description"/></div></spring:bind>

        Since
        <spring:bind path="since"><div><form:input type="date" path="since" /></div></spring:bind>

        Till
        <spring:bind path="till"><div><form:input type="date" path="till"/></div></spring:bind>

        <form:hidden path="images"/>

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
