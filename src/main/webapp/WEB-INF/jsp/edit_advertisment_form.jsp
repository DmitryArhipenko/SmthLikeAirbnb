<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Advertisment Form</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div>
    <form:form method="PUT" modelAttribute="current_advertisment" class="adv-form">
        <h2 class="adv-form-heading">Edit this advertisment</h2>

        Now you are editing the adv with id = ${current_advertisment.id}
        <form:hidden path="id"/>


        <div><form:input type="text" path="title" class="form-control" placeholder="Title"/></div>

        <div>Here choose the type of your apartment
            <form:select path="apartment_type">
                <form:option value="" label="Choose"/>
                <form:options items="${availableOptions}"/>
            </form:select></div>

        <div><form:input type="text" path="city" class="form-control" placeholder="City"/></div>

        <div><form:input type="text" path="address" class="form-control" placeholder="Address"/></div>

        <div><form:input type="text" path="description" class="form-control" placeholder="Description"/></div>

        Since
        <spring:bind path="since">
            <div><form:input type="date" path="since"/></div>
        </spring:bind>

        Till
        <spring:bind path="till">
            <div><form:input type="date" path="till"/></div>
        </spring:bind>

        <form:hidden path="user"/>

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