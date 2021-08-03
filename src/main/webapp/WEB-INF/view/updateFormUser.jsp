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
            <form action="<%=request.getContextPath()%>/users/update" method="post">
                <caption>
                    <h2>
                        Update User
                    </h2>
                </caption>
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                <input type="hidden" name="email" value="<c:out value='${user.email}' />"/>
                <input type="hidden" name="password" value="<c:out value='${user.password}' />"/>
                <fieldset class="form-group">
                    <label>User First Name</label> <input type="text"
                                                          value="<c:out value='${user.firstName}' />"
                                                          class="form-control"
                                                          name="firstName" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>User Last Name</label> <input type="text"
                                                         value="<c:out value='${user.lastName}' />"
                                                         class="form-control"
                                                         name="lastName" required="required">
                </fieldset>
                <br>
                <label>User Roles</label><br>
                <c:set var="userRoles" value="${user.roles}"/>
                <c:forEach var="role" items="${allRoles}">
                    <c:if test="${userRoles.contains(role)}">
                        <input type="checkbox" name="roles" checked
                               value="${role.id}"/>
                        ${role.userRole.name()}<br>
                    </c:if>
                    <c:if test="${!userRoles.contains(role)}">
                        <input type="checkbox" name="roles"
                               value="${role.id}"/>
                        ${role.userRole.name()}<br>
                    </c:if>
                </c:forEach>
                <br>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
