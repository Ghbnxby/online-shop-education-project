<!DOCTYPE html>

<html>
<head>
    <title>Personal User's cabinet</title>
</head>
<body>
<h1>User List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>FullName</th><th>Edit</th></tr>
    <c:forEach items="${user}" var="user">
        <tr>

            <td>${user.fullname}</td>
            <td><a href="view?id=${user.id}">Edit</a></td>
        </tr>
</table>
</c:forEach>



<form method="post" action="/product/list">

    View list products
    <input type="submit" value="view" />
</form>

<br/>
<br/>

<form method="post" action="/share/list">

    View list shares
    <input type="submit" value="view" />
</form>


</body>
</html>