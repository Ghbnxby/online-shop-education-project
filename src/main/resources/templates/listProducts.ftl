<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>Products List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Code</th><th>Price</th><th>Image</th><th>CreateDate</th><th>active</th><th>edit</th><th>delete</th></tr>
    <c:forEach var="product" items="${list}">
        <tr>
            <td>${product.id}</td>
            <td>${product.title}</td>
            <td>${product.code}</td>
            <td>${product.price}</td>
            <td>${product.image}</td>
            <td>${product.createDate}</td>
            <td>${product.active}</td>
            <td><a href="edit/${product.id}">Edit</a></td>
            <td><a href="delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addProduct.ftl">Add New Product</a>
<a href="view.ftl">Return Start page</a>

</body>
</html>