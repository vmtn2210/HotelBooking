<%-- 
    Document   : viewCart
    Created on : Feb 23, 2022, 10:59:52 AM
    Author     : vende
--%>

<%@page import="java.util.Map"%>
<%@page import="nguyenbk.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Your cart includes</h1>
        <c:if test="${not empty sessionScope}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart}">
                <c:set var="items" value="${cart.items}"/>
                <c:if test="${not empty items}">
                    <form action="addBookController">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="book" items="${items.keySet()}" varStatus="counter">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <td>
                                            ${book}
                                        </td>
                                        <td>
                                            ${items.get(book)}
                                        </td>
                                        <td>
                                            <input type="checkbox" name="chkItem" 
                                                   value="${book}" />
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <th colspan="3">
                                        <input type="submit" value="Go Shopping" name="btAction" />
                                    </th>
                                    <th>
                                        <input type="submit" value="Remove Your Choice Items" name="btAction" />
                                    </th>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </c:if>
                <c:if test="${empty items}">
                    <h2>No item in cart!!!!!</h2>
                    <form action="addBookController">
                        <input type="submit" 
                               value="Go Shopping" 
                               name="btAction" />
                    </form>
                </c:if>
            </c:if>
            <c:if test="${empty items}">
                <h2>No cart!!!!!</h2>
                <form action="addBookController">
                    <input type="submit" 
                           value="Go Shopping" 
                           name="btAction" />
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty sessionScope}">
            <h2>No cart!!!!!</h2>
            <form action="addBookController">
                <input type="submit" 
                       value="Go Shopping" 
                       name="btAction" />
            </form>
        </c:if>
        <%--        <%
                    //1. Cust goes to his/her cart place
                    if (session != null) {
                        //2. Cust takes his/her place
                        CartObject cart = (CartObject) session.getAttribute("CART");
                        if (cart != null) {
                            //3. Cust gets all items
                            Map<String, Integer> items = cart.getItem();
                            if (items != null) {
                                %>
                                <form action="DispathServlet">
                                <table border="1">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Title</th>
                                            <th>Quantity</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% 
                                            int count = 0;
                                            for (String item: items.keySet()) {
                                                %>
                                                <tr>
                                                    <td>
                                                        <%= ++count %>
                                                    </td>
                                                    <td>
                                                        <%= item %>
                                                    </td>
                                                    <td>
                                                        <%= items.get(item) %>
                                                    </td>
                                                    <td>
                                                        <input type="checkbox" name="chkItem" 
                                                               value="<%= item %>" />
                                                    </td>
                                                </tr>
                                        <%
                                            }// end for
                                        %>
                                        <tr>
                                            <th colspan="3">
                                                <a href="shopping.html">Add More Books to Your Cart</a>
                                            </th>
                                            <th>
                                                <input type="submit" value="Remove Your Choice Items" name="btAction" />
                                            </th>
                                        </tr>
                                    </tbody>
                                </table>
                                </form>
                                        
                <%
                            }//end items have value
                        } else {// end cart is existed 
                            %>
                            <h2>No Cart!!!!!</h2>
                <%
                        }
                    }
                %> --%>
    </body>
</html>
