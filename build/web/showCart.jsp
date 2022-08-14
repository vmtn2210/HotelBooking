<%-- 
    Document   : showCart
    Created on : Feb 23, 2022, 10:59:32 AM
    Author     : ASUS
--%>

<%--<%@page import="java.util.Map"%>
<%@page import="hadn.cart.CartObject"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Page</title>
    </head>
    <body>
        <h1>Your cart includes</h1>
        <c:set var="cart" value="${sessionScope.CART}" />
        <c:if test="${not empty cart}">
            <c:set var="items" value="${cart.items}"/>
            <c:if test="${not empty items}">
                <form action="DispatchServlet">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>BookingID</th>
                                <th>HotelName</th>
                                <th>roomID</th>
                                <th>CheckInDay</th>
                                <th>CheckOutDay</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Email</th>
                                <th>Action</th>
                                <th>ConfirmBooking</th>
                                <th>Update Amount Of Room</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${items.keySet()}" varStatus="counter">

                            <form action="DispatchServlet">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${item}
                                        <input type="hidden" name="txtBookingID" value="${item}"/>
                                    </td>
                                    <td>
                                        ${items.get(item).getHotelName()}
                                        <input type="hidden" name="txtHotelName" value="${items.get(item).getHotelName()}" />
                                    </td>
                                    <td>
                                        ${items.get(item).getRoomID()}
                                        <input type="hidden" name="txtRoomID" value="${items.get(item).getRoomID()}" />
                                    </td>
                                    <td>
                                        ${items.get(item).getCheckInDate()}
                                        <input type="hidden" name="txtCheckInDate" value=" ${items.get(item).getCheckInDate()}" />
                                    </td>
                                    <td>
                                        ${items.get(item).getCheckOutDate()}
                                        <input type="hidden" name="txtCheckOutDate" value="${items.get(item).getCheckOutDate()}" />
                                    </td>
                                    <td>
                                        ${items.get(item).price}
                                        <input type="hidden" name="txtPrice" value="${items.get(item).price}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtAmount" value="${items.get(item).amount}" />
                                    </td>
                                    <td>
                                        ${items.get(item).getEmail()}
                                        <input type="hidden" name="txtEmail" value="${items.get(item).getEmail()}" />
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkItem" value="${item}" />
                                    </td>
                                    <td>
                                        <input type="submit" value="Confirm booking" name="btAction" />
                                    </td>
                                    <td>
                                        <input type="submit" value="Update amount of room" name="btAction" />
                                    </td>
                                </tr>
                            </form>



                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="user.jsp">Add More Books to Your Cart</a>
                            </td>
                            <td>
                                <input type="submit" value="Remove Your Choice Items" name="btAction" />
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </c:if>
            <c:if test="${empty items}">
                <h2>No Cart!!</h2>
                <a href="user.jsp">Click here to go back booking</a>
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
            <a href="user.jsp">Click here to go back booking</a>
            <h2>No Cart!!</h2>
        </c:if>
    </body>
</html>
