<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/products/form/add" class="btn btn-success">Add
                    New Product</a>
            </div>
        </security:authorize>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Producer</th>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <th>Actions</th>
                </security:authorize>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.producer}"/></td>

                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <td>
                            <a href="<%=request.getContextPath()%>/products/form/update?id=<c:out value='${product.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="<%=request.getContextPath()%>/products/delete?id=<c:out value='${product.id}' />">Delete</a>
                        </td>
                    </security:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
