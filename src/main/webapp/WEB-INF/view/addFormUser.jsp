<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product System</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <c:import url="navibar.jsp"/>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form:form method="POST" modelAttribute="userForm"
                       action="${pageContext.request.contextPath}/users/form/add">
                <caption>
                    <h2>
                        Add New User
                    </h2>
                </caption>
                <span style="color:red;">${message}</span>
                <fieldset class="form-group">
                    <label>User First Name</label> <input type="text"
                                                          class="form-control"
                                                          name="firstName" required="required">
                    <form:errors style="color:red;" path="firstName"></form:errors>
                </fieldset>
                <fieldset class="form-group">
                    <label>User Last Name</label> <input type="text"
                                                         class="form-control"
                                                         name="lastName" required="required">
                    <form:errors style="color:red;" path="lastName"></form:errors>
                </fieldset>
                <fieldset class="form-group">
                    <label>User Email</label> <input type="text"
                                                     class="form-control"
                                                     name="email" required="required">
                    <form:errors style="color:red;" path="email"></form:errors>
                </fieldset>
                <fieldset class="form-group">
                    <label>User Password</label> <input type="password"
                                                        class="form-control"
                                                        name="password" required="required">
                    <form:errors style="color:red;" path="password"></form:errors>
                </fieldset>
                <label>User Roles</label><br>
                <c:forEach var="role" items="${allRoles}">
                    <input type="checkbox" name="rolesIds"
                           value="${role.id}"/>
                    ${role.userRole.name()}<br>
                </c:forEach>
                <form:errors style="color:red;" path="roles"></form:errors>
                <br>
                <button type="submit" class="btn btn-success">Save</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
