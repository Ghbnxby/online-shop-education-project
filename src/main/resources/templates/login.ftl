
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="style/style.css" />

</head>
<body>

 <#--<#if ${param.error}>-->
    <#--Invalid username and password.-->

 <#--<#elseif ${param.logout}>-->
    <#--You have been logget out.-->
 <#--<#else> jj-->
 <#--</#if>-->

    <#--<form action="@{/login}" method="post">-->
        <#--<div><label> User Name : <input type="text" name="login"/> </label></div>-->
        <#--<div><label> Password: <input type="password" name="password"/></label></div>-->
        <#--<div><input type="submit" value="Sign In"/> </div>-->

    <#--</form>-->
 <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
     <@spring.message "login.bad.credentials"/>
 </#if>

 <form action="/j_spring_security_check" method="post">
     <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="admin"><br/>
     <input type="password" class="form-control" name="j_password" placeholder="Password" required value="admin">
     <input type="submit" value="Login!">
 </form>

 <#--<div class="container" style="width: 300px;">-->

     <#--<form action="@{/login}" method="post">-->

         <#--<input type="text" class="form-control" name="login" placeholder="Email address" required autofocus value="">-->
         <#--<input type="password" class="form-control" name="password" placeholder="Password" required value="">-->
         <#--<button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>-->
     <#--</form>-->
 <#--</div>-->















 <!--<h1>Login </h1>
 <form method="post" action="/user/login">
     <table >

         <tr>
             <td>Login :</td>
             <td><input type="text" name="login" value=""></td>
         </tr>
         <tr>
             <td>Password :</td>
             <td><input type="password" name="password" value=""></td>
         </tr>
         <tr>
             <td> </td>
             <td><input type="submit" value="Enter" /></td>
         </tr>
     </table>
 </form>

 <br/>-->



</body>
</html>