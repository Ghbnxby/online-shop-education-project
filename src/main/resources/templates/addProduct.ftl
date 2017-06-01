
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
<form method="post" action="/product/save">
    <table >

        <tr>
            <td>Title :</td>
            <td><input type="text" name="title" value=""/></td>
        </tr>
        <tr>
            <td>Code :</td>
            <td><input type="text" name="code" value=""/></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><input type="text" name="price" value=""/></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input name="image" type="file" value=""/></td>
        </tr>
        <tr>
            <td>CreateDate</td>
            <td><input name="createDate" type="text" value="" /></td>
        </tr>
        <tr>
            <td>Active</td>
            <td><input type="text" name="active" value=""/></td>
        </tr>

        <tr>
            <td>Category</td>
            <td> <select name="category">
                <option>tkanevye</option></td>
        </tr>
        <tr>
            <td> </td>

        </tr>
    </table>
    <td><input type="submit" value="Enter" /></td>
</form>


</body>
</html>