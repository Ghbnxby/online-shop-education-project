<!DOCTYPE html>

<html>
<head>
    <title>View Page</title>
</head>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>FullName</th><th>Edit</th></tr>
    <c:forEach var="admin" items="${admin}">
        <tr>
            <td>${admin.id}</td>
            <td>${admin.fullname}</td>

            <td><a href="/admin/save${admin.id}">Edit</a></td>

        </tr>
    </c:forEach>
</table>




<form:form method="post" action="/product/view">

    View list products
    <input type="submit" value="view" />
</form:form>

<br/>
<br/>

<form:form method="post" action="/share/view">

    View list shares
    <input type="submit" value="view" />
</form:form>


</body>
</html>