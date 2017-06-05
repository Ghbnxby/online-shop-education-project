<!DOCTYPE html>

<html>
<head>
    <title>User Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>Save </h1>
<form method="post" action="/user/save">

    <table >

        <tr>
            <td>Login :</td>
            <td><input type="text" name="login" value=""/></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td>Fullname :</td>
            <td><input type="text" name="fullname" value=""/></td>
        </tr>

    </table>
    <br/>
    <input type="submit" value="Enter" />
</form>
<br/>
<br/>



</body>
</html>