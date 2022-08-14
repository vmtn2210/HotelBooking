<%-- 
    Document   : user
    Created on : Apr 23, 2022, 4:08:02 AM
    Author     : ASUS
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <h1>Welcome ${user.name}</h1>
        <form action="DispatchServlet">
            Search <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <select name="cboSearch">
                <c:set var="searchOption" value="${param.cboSearch}"/>
                <c:if test="${not empty searchOption}">
                    <option>${searchOption}</option>
                </c:if>
                <option> HotelArea</option>
                <option>HotelName</option>
                <option>checkInDate</option>
                <option>checkOutDate</option>
                <option>AmountOfRoom</option>

            </select><br/>
            <input type="submit" value="Search" name="btAction" />
        </form>
        <c:set var="searchResult" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchResult}">
            <c:set var="hotels" value="${requestScope.HOTELS}" />
            <c:if test="${not empty hotels}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>HotelName</th>
                            <th>HotelArea</th>
                            <th>kindName</th>
                            <th>price</th>
                            <th>RoomID</th>
                            <th>RoomName</th>
                            <th>amountOfRoom</th>
                            <th>checkInDate</th>
                            <th>checkOutDate</th>
                            <th>Booking ID</th>
                            <th>Booking</th>
                            <th>View Booking</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${hotels}" varStatus="counter">
                        <form action="DispatchServlet">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.hotelName}
                                    <input type="hidden" name="txtHotelName" value="${dto.hotelName}" />
                                </td>
                                <td>
                                    ${dto.hotelArea}
                                </td>
                                <td>
                                    ${dto.kindName}
                                </td>
                                <td>
                                    ${dto.price}
                                    <input type="hidden" name="txtPrice" value="${dto.price}" />
                                </td>
                                <td>
                                    ${dto.roomID}
                                    <input type="hidden" name="txtRoomID" value="${dto.roomID}" />
                                </td>
                                <td>
                                    ${dto.roomName}
                                </td>
                                <td>
                                    ${dto.amountOfRoom}
                                </td>
                                <td>
                                    ${dto.checkInDate}
                                    <input type="hidden" name="txtCheckInDate" value="${dto.checkInDate}" />
                                </td>
                                <td>
                                    ${dto.checkOutDate}
                                    <input type="hidden" name="txtCheckOutDate" value="${dto.checkOutDate}" />
                                </td>
                                <td>
                                    <input type="text" name="txtBookingID" value="" placeholder="please enter booking ID with (bXX)"/>
                                </td>
                                <td>
                                    <input type="submit" value="Booking" name="btAction"/>
                                    <input type="hidden" name="txtEmail" value="${user.email}" />
                                    <input type="hidden" name="lastSearchValue" value="${searchResult}" />
                                    <input type="hidden" name="searchOption" value="${searchOption}" />
                                </td>
                                <td>
                                    <input type="submit" value="View Booking" name="btAction"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty hotels}">
            <c:set var="error" value="${requestScope.ERROR}"/>
            <h1>${error}</h1>
        </c:if>
    </c:if>
</body>
</html>
