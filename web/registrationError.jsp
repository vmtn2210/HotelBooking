<%-- 
    Document   : registrationError
    Created on : Apr 23, 2022, 5:41:57 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.CREATEERRORS}"/>
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(e.g. 6 - 20 chars) <br/>
            <c:if test="${not empty errors.usernameLengthError}">
                <font color="red">
                    ${errors.usernameLengthError}
                </font><br/>
            </c:if>
            <c:if test="${not empty errors.usernameIsExisted}">
                <font color="red">
                    ${errors.usernameIsExisted}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" />(e.g. 6 - 30 chars)<br/>
            <c:if test="${not empty errors.passwordLengthError}">
                <font color="red">
                    ${errors.passwordLengthError}
                </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatched}">
                <font color="red">
                    ${errors.confirmNotMatched}
                </font><br/>
            </c:if>
            Name* <input type="text" name="txtFullname" value="${param.txtFullname}" />(e.g. 2 - 50 chars)<br/>
            <c:if test="${not empty errors.nameLengthError}">
                <font color="red">
                    ${errors.nameLengthError}
                </font><br/>
            </c:if>
            Phone* <input type="text" name="txtPhone" value="${param.txtPhone}" />(e.g. 2 - 50 chars)<br/>
            <c:if test="${not empty errors.phoneLengthError}">
                <font color="red">
                    ${errors.phoneLengthError}
                </font><br/>
            </c:if>
            Address* <input type="text" name="txtPhone" value="${param.txtAddress}" />(e.g. 2 - 50 chars)<br/>
            <c:if test="${not empty errors.addressLengthError}">
                <font color="red">
                    ${errors.addressLengthError}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
        </form>
    </body>
</html>
