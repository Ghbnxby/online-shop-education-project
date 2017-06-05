<!DOCTYPE html>

<html lang="en">

<body>
<form method="post" action="/user/update?id=${user.id}">
<table border="2" width="70%" cellpadding="2">
    <tr><th></th><th>new change</th></tr>

        <tr>
            <td>id</td>
            <td>${user.id}</td>
            </tr><br/>
        <tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" value="${user.login}"/></td>
            </tr><br/>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
            </tr><br/>
        <tr>
            <td>Full Name</td>
            <td><input type="text" name="fullname" value="${user.fullname}"/></td>
        </tr><br/>

        <br/>
</table>
    <td><input type="submit" value="Update" /></td>
    </form>

<br/>

<a href="/user/cabinet">Return</a>

</body>


</html>