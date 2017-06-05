
<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>Share List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Title</th><th>Description</th><th>StartDate</th><th>EndDate</th><th>Edit</th><th>Delete</th></tr>
<#list list as share>
        <tr>

            <td>${share.title}</td>
            <td>${share.description}</td>
            <td>${share.startDate}</td>
            <td>${share.endDate}</td>

            <td><a href="view?id=${share.id}">Edit</a></td>
            <td><a href="delete?id=${share.id}">Delete</a></td>
        </tr>
    </#list>
</table>
<br/>
<a href="add">Add New Share</a>
<a href="/user/cabinet">Return Start page</a>

</body>
</html>