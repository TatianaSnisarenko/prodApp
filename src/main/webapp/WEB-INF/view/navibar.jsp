<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: tomato">
    <div>
        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Product System </a>
    </div>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <ul class="navbar-nav">
            <li><a href="/users"
                   class="nav-link">Users</a></li>
        </ul>
    </security:authorize>
    <ul class="navbar-nav">
        <li><a href="/products"
               class="nav-link">Products</a></li>
    </ul>
    <ul class="navbar-nav">
        <li><a href="/producers"
               class="nav-link">Producers</a></li>
    </ul>
    <ul class="navbar-nav">
        <li><a href="/logout"
               class="nav-link">Logout</a></li>
    </ul>
</nav>