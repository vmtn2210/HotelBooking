<%-- 
    Document   : registration
    Created on : Apr 23, 2022, 4:07:48 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form action="DispatchServlet" method="POST">
            Email* <input type="email" name="txtUsername" value="" />(e.g. 6 - 20 chars) <br/>
            Password* <input type="password" name="txtPassword" value="" />(e.g. 6 - 30 chars)<br/>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            Name* <input type="text" name="txtFullname" value="" />(e.g. 2 - 50 chars)<br/>
            Phone* <input type="text" name="txtPhone" value="" />(e.g. 2 - 50 chars)<br/>
            Address* <input type="text" name="txtAddress" value="" />(e.g. 2 - 50 chars)<br/>
            <input type="submit" value="Create New Account" name="btAction" />
        </form>
    </body>
</html>
