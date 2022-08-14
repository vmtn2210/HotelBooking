<%-- 
    Document   : admin
    Created on : Apr 23, 2022, 4:07:33 AM
    Author     : ASUS
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
       <form action="DispatchServlet">
            Search <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> 
            <select name="cboSearch">
                <c:set var="searchOption" value="${param.cboSearch}"/>
                <c:if test="${not empty searchOption}">
                    <option>${searchOption}</option>
                </c:if>
                <option>HotelArea</option>
                <option>HotelName</option>
                <option>checkInDate</option>
                <option>checkOutDate</option>
                <option>AmountOfRoom</option>
                
            </select><br/>
            <input type="submit" value="Search ADMIN" name="btAction" />
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${hotels}" varStatus="counter">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.hotelName}
                                </td>
                                <td>
                                    ${dto.hotelArea}
                                </td>
                                <td>
                                    ${dto.kindName}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.roomID}
                                </td>
                                <td>
                                    ${dto.roomName}
                                </td>
                                <td>
                                    ${dto.amountOfRoom}
                                </td>
                                <td>
                                    ${dto.checkInDate}
                                </td>
                                <td>
                                    ${dto.checkOutDate}
                                </td>
                            </tr>
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
