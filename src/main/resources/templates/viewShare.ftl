<!DOCTYPE html>

<html lang="en">

<body>
<form method="post" action="/share/edit?id=${share.id}">
<table border="2" width="70%" cellpadding="2">
    <tr><th></th><th>new change</th></tr>

        <tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${share.title}"/></td>
            </tr><br/>
        <tr>
            <td>Code</td>
            <td><input type="text" name="description" value="${share.description}"/></td>
        </tr><br/>
        <tr>
            <td>Price</td>
            <td><input type="text" name="startDate" value="${share.startDate}"/></td>
        </tr><br/>
        <tr>
            <td>Image</td>
            <td><input type="text" name="endDate" value="${share.endDate}"/></td>
        </tr>

        <br/>



</table>
    <td><input type="submit" value="Save" /></td>
    </form>

<br/>

<a href="/share/list">Return</a>

</body>


</html>