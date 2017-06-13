<!DOCTYPE html>

<html lang="en">

<body>
<form method="post" action="/category/edit?id=${category.id}">
    <table border="2" width="70%" cellpadding="2">
        <tr><th></th><th>new change</th></tr>

        <tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${category.title}"/></td>
        </tr><br/>

        <br/>

    </table>
    <td><input type="submit" value="Save" /></td>
</form>

<br/>

<a href="/category/list">Return</a>

</body>


</html>