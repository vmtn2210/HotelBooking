<%-- 
    Document   : search
    Created on : Feb 11, 2022, 11:23:56 AM
    Author     : vende
--%>

<%--<%@page import="java.util.List"%>
<%@page import="nguyenbk.Login.LoginDTO"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.FULLNAME} // coi chừng 0 điểm
        </font>
        <h1>Search Page</h1>
        <form action="searchController">
            Search Value  <input type="text" name="txtSearchValue" 
                                 value="${param.txtSearchValue}" /><br/>
            <input type="submit" value="Search" name="btAction" />
        </form><br/>
        <form action="logoutController" method="POST">
             <input type="submit" value="Logout" name="btAction" />
        </form><br/>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="updateAccountServlet" method="POST">
                                <tr>
                                    <td>
                                        ${counter.count}
                                        .</td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" 
                                               value="${dto.username}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" 
                                               value="${dto.password}" />
                                    </td>
                                    <td>
                                        ${dto.fullname}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="ON" 
                                                <c:if test="${dto.role}">
                                                   checked="checked"
                                                </c:if>
                                                   />
                                    </td>
                                    <td>
                                        <c:url var="deleteAccount" value="deleteAccountServlet">
                                            <c:param name="btAction" value="Delete"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${deleteAccount}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btAction" />
                                        <input type="hidden" name="lastSearchValue" 
                                               value="${searchValue}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty result}">
                <h2>
                    No record is matched!!
                </h2> 
            </c:if>
        </c:if>
        <%--
        <%
                Cookie[]cookies = request.getCookies();
                if(cookies != null){
                    Cookie lastCookie = cookies[cookies.length - 1];
                    String username = lastCookie.getName();
                    String password = lastCookie.getValue();
                    %>
                    <font color="red">
                        Welcome, <%= username %>
                    </font>
            <%
                }
            %>
            <form action="DispathServlet">
                <h1>Welcome to DB Servlet</h1>
                Name<input type="text" name="txtSearchValue" 
                           value="<%= request.getParameter("txtSearchValue")%>"/> <br/>
                <input type="submit" value="Search" name="btAction"/>
                <input type="submit" value="Logout" name="btAction" />
            </form>

        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<LoginDTO> result
                        = (List<LoginDTO>) request.getAttribute("SEARCHRESULT");

                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (LoginDTO dto : result) {
                        String urlRewriting = "DispathServlet"
                                + "?btAction=delete"
                                + "&pk=" + dto.getUsername()
                                + "&lastSearchValue=" + searchValue;
                        
                %>
            <form action="DispathServlet">   
                    <tr>
                    <td>
                        <%= ++count%>
                        .</td>
                    <td>
                        <%= dto.getUsername()%>
                        <input type="hidden" name="txtUsername" value="<%= dto.getUsername() %>" />
                    </td>
                    <td>
                        <input type="text" name="txtPassword" value=" <%= dto.getPassword()%>" />
                    </td>
                    <td>
                        <%= dto.getFullname()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkAdmin" value="ON" 
                               <% 
                                if (dto.isRole()) {
                                        %>
                                        checked="checked"
                               <%
                                }//this is admin
                               %>
                               />
                    </td>
                    <td>
                        <a href="<%= urlRewriting%>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearchValue" value="<%= searchValue %>" />
                        <input type="submit" name="btAction" value="Update" />
                    </td>
                </tr>
            </form>    
                <%
                    }//end of traversing result
                %>
            </tbody>
        </table>

        <%
        } else {
        %>
        <h2>
            No record matched!!!
        </h2>
        <%
                }
            }//search Value has value
        %>
        --%>
    </body>
</html>
