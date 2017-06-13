

<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>Category List</h1>

<table border="2" width="70%" cellpadding="2">
    <tr><th>Title</th><th>Edit</th><th>Delete</th></tr>

<#list list as category>
    <tr>

        <td>${category.title}</td>



        <td><a href="view?id=${category.id}">Edit</a></td>
        <td><a href="delete?id=${category.id}">Delete</a></td>
    </tr>
</#list>
</table>
<br/>
<a href="add">Add New Category</a>


</body>
</html>