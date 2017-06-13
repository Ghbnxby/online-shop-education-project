

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="style/style.css" />
</head>

<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Start Page</h1>
        <p class="lead">

        </p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login"/> Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" /> role="button">Выйти</a></p>

        </sec:authorize>
    </div>


</div>
</body>
</html>




















<#--<!DOCTYPE html>-->

<#--<html lang="en">-->

<#--<body>-->
<#--Date: ${time?date}-->
<#--<br>-->
<#--Time: ${time?time}-->
<#--<br>-->
<#--Message: ${message}-->
<#--HELLO!!!-->
<#--<br/>-->
<#--<h1 th:inline="text">Hello </h1>-->
<#--<form th:action="@{/logout}" method="post">-->
    <#--<input type="submit" value="Sign Out"/>-->
<#--</form>-->

<#--<a href="loginUser">Sign in to your account</a>-->
<#--<a href="saveUser">Register</a>-->
<#--</body>-->

<#--</html>-->