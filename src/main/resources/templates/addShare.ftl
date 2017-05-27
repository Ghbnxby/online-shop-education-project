<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>Save </h1>
<form:form method="post" action="/share/add">
    <table >

        <tr>
            <td>Title :</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Code :</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><form:input path="startDate" /></td>
        </tr>
        <tr>
            <td>CreateDate</td>
            <td><form:input path="endDate" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Enter" /></td>
        </tr>
    </table>
</form:form>


</body>
</html>