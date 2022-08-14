<%-- 
    Document   : login
    Created on : Apr 23, 2022, 4:06:53 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="DispatchServlet" method="POST">
            userID  <input type="text" name="txtUserName" value="" /> <br/>
            password <input type="password" name="txtPassword" value="" /> <br/>
            <input type="submit" value="Login" name="btAction" /> 
            <input type="reset" value="Reset" /> 
        </form>
    </body>
</html>
