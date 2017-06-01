

<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>Products List</h1>

<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Code</th><th>Price</th><th>Active</th><th>CreateDate</th><th>Image</th><th>Category</th><th>Edit</th><th>Delete</th></tr>

<#list list as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.title}</td>
            <td>${product.code}</td>
            <td>${product.price}</td>
            <td>${product.active}</td>
            <td>${product.createDate}</td>
            <td><p><img src="images/${product.image}" alt=""/></p></td>

            <td>${product.category.title}</td>


            <td><a href="view?id=${product.id}">Edit</a></td>
            <td><a href="delete?id=${product.id}">Delete</a></td>
        </tr>
    </#list>
</table>
<br/>
<a href="add">Add New Product</a>


</body>
</html>