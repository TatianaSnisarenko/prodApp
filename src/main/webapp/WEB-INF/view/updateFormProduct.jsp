<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <form action="<%=request.getContextPath()%>/products" method="post">
                <caption>
                    <h2>
                        Update Product
                    </h2>
                </caption>
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
                <fieldset class="form-group">
                    <label>Product Name</label> <input type="text"
                                                       value="<c:out value='${product.name}' />"
                                                       class="form-control"
                                                       name="name" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Product Price</label> <input type="number" min="0" step="any"
                                                        value="<c:out value='${product.price}' />"
                                                        class="form-control"
                                                        name="price" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Producer</label>
                    <select name="producer" required="required">
                        <c:forEach var="producer" items="${producers}">
                            <option value="${producer.id}">${producer.name}</option>
                        </c:forEach>
                    </select>
                </fieldset>
                <br>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
