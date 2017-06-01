<!DOCTYPE html>

<html>
<head>
    <title>View Page</title>
</head>
<body>
<h1>User List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>FullName</th><th>Edit</th></tr>
    <c:forEach var="user" items="${user}">
        <tr>
            <td>${user.id}</td>
            <td>${user.fullname}</td>

            <td><a href="/admin/save${admin.id}">Edit</a></td>

        </tr>
    </c:forEach>
</table>




<form method="post" action="/product/list">

    View list products
    <input type="submit" value="view" />
</form>

<br/>
<br/>

<form method="post" action="/share/view">

    View list shares
    <input type="submit" value="view" />
</form>


</body>
</html>