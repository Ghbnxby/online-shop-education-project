<!DOCTYPE html>

<html lang="en">

<body>
<form method="post" action="/product/edit?id=${product.id}">
<table border="2" width="70%" cellpadding="2">
    <tr><th></th><th>now</th><th>new change</th></tr>

        <tr>
            <td>id</td>
            <td>${product.id}</td>
            <td></td>
        </tr><br/>
        <tr>
        <tr>
            <td>Title</td>
            <td>${product.title}</td>
            <td><input type="text" name="title" value="${product.title}"/></td>
            </tr><br/>
        <tr>
            <td>Code</td>
            <td>${product.code}</td>
            <td><input type="text" name="code" value="${product.code}"/></td>
        </tr><br/>
        <tr>
            <td>Price</td>
            <td>${product.price}</td>
            <td><input type="text" name="price" value="${product.price}"/></td>
        </tr><br/>
        <tr>
            <td>Image</td>
            <td>${product.image}</td>
            <td><input type="file" name="image" value="${product.image}"/></td>
        </tr>
    <tr>
            <td>Active</td>
            <td>${product.active}</td>
            <td><input type="text" name="active" value="${product.active}"/></td>
    </tr>


        <tr>
            <td>CreateDate</td>
            <td>${product.createDate}</td>
            <td><input type="text" name="createDate" value="${product.createDate}"/></td>
        </tr><br/>
        <tr>
            <td>Category</td>
            <td>${product.category.title}</td>
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