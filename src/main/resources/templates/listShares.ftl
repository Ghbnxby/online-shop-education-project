<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>List Page</title>
</head>
<body>
<h1>Share List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Description</th><th>StartDate</th><th>EndDate</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="share" items="${list}">
        <tr>
            <td>${share.id}</td>
            <td>${share.title}</td>
            <td>${share.description}</td>
            <td>${share.startDate}</td>
            <td>${share.endDate}</td>

            <td><a href="edit/${share.id}">Edit</a></td>
            <td><a href="delete/${share.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addShare.ftl">Add New Share</a>
<a href="viewUser.ftl">Return Start page</a>

</body>
</html>