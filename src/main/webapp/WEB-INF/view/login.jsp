<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <title>Product Application</title>
    <style>
        <%@include file="/WEB-INF/view/css/login.css" %>
    </style>
</head>
<body>
<form class="login" method="POST" action="login">
    <input name="username" type="text" class="form-control" placeholder="Username"/>
    <input name="password" type="password" class="form-control" placeholder="Password"/>

    <button type="submit">Login</button>
    <br>
    <br>
    <span style="color:red;">${error}</span>
    <br>
    <h2 align="center"><a href="${pageContext.request.contextPath}/users/registration">Create an account</a></h2>
</form>
</body>
</html>