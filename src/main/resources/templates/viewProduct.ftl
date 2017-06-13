<!DOCTYPE html>

<html lang="en">

<body>
<form method="post" action="/product/edit?id=${product.id}">
<table border="2" width="70%" cellpadding="2">
    <tr><th></th><th>new change</th></tr>

        <tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${product.title}"/></td>
            </tr><br/>
        <tr>
            <td>Code</td>
            <td><input type="text" name="code" value="${product.code}"/></td>
        </tr><br/>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"/></td>
        </tr><br/>
        <tr>
            <td>Image</td>
            <td><input type="file" name="image" value="${product.image}"/></td>
        </tr>
    <tr>
            <td>Active</td>
            <td><input type="text" name="active" value="${product.active}"/></td>
    </tr>


        <tr>
            <td>CreateDate</td>
            <td><input type="text" name="createDate" value="${product.createDate}"/></td>
        </tr><br/>
        <tr>
            <td>Category</td>
            <td><input type="text" name="category" value="${product.category.title}"/></td>
        </tr><br/>

        <br/>



</table>
    <td><input type="submit" value="Save" /></td>
    </form>

<br/>

<a href="/product/list">Return</a>

</body>


</html>