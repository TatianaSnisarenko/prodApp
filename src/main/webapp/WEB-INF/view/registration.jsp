<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Product Application</title>
    <style>
        <%@include file="/WEB-INF/view/css/login.css" %>
    </style>
</head>
<body>

<form:form class="login" method="POST" modelAttribute="userForm" action="/users/registration">
    <h2>Create your account</h2>
    <span style="color:red;">${message}</span>
    <spring:bind path="firstName">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="firstName" class="form-control" placeholder="first name"
                        autofocus="true"></form:input>
            <form:errors style="color:red;" path="firstName"></form:errors>
        </div>
    </spring:bind>

    <span>${message}</span>
    <spring:bind path="lastName">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="lastName" class="form-control" placeholder="last name"
                        autofocus="true"></form:input>
            <form:errors style="color:red;" path="lastName"></form:errors>
        </div>
    </spring:bind>

    <span>${message}</span>
    <spring:bind path="email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="email" class="form-control" placeholder="Username(use email as user name)"
                        autofocus="true"></form:input>
            <form:errors style="color:red;" path="email"></form:errors>
        </div>
    </spring:bind>

    <span>${message}</span>
    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
            <form:errors style="color:red;" path="password"></form:errors>
        </div>
    </spring:bind>

    <button type="submit">Submit</button>
    <h2 align="center"><a href="${pageContext.request.contextPath}/login">Login</a></h2>
</form:form>
</body>
</html>