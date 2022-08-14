/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tanvm.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class HotelDAO {
    private static final String SEARCH_BY_HOTEL_NAME = "SELECT h.HotelName, h.HotelArea, k.kindName, r.price, r.RoomID, r.RoomName, r.amountOfRoom, r.checkInDate, r.checkOutDate FROM tblHotels h, tblKinds k, tblRooms r WHERE  h.HotelName like ? AND r.HotelID = h.HotelID AND r.kindID = k.kindID";
    private static final String SEARCH_BY_HOTEL_AREA = "SELECT h.HotelName, h.HotelArea, k.kindName, r.price, r.RoomID, r.RoomName, r.amountOfRoom, r.checkInDate, r.checkOutDate FROM tblHotels h, tblKinds k, tblRooms r WHERE  h.HotelArea like ? AND r.HotelID = h.HotelID AND r.kindID = k.kindID";
    private static final String SEARCH_BY_HOTEL_CHECKINDATE = "SELECT h.HotelName, h.HotelArea, k.kindName, r.price, r.RoomID, r.RoomName, r.amountOfRoom, r.checkInDate, r.checkOutDate FROM tblHotels h, tblKinds k, tblRooms r WHERE  r.checkInDate like ? AND r.HotelID = h.HotelID AND r.kindID = k.kindID";
    private static final String SEARCH_BY_HOTEL_CHECKOUTDATE = "SELECT h.HotelName, h.HotelArea, k.kindName, r.price, r.RoomID, r.RoomName, r.amountOfRoom, r.checkInDate, r.checkOutDate FROM tblHotels h, tblKinds k, tblRooms r WHERE  r.checkOutDate like ? AND r.HotelID = h.HotelID AND r.kindID = k.kindID";
    private static final String SEARCH_BY_HOTEL_AMOUNTOFROOM = "SELECT h.HotelName, h.HotelArea, k.kindName, r.price, r.RoomID, r.RoomName, r.amountOfRoom, r.checkInDate, r.checkOutDate FROM tblHotels h, tblKinds k, tblRooms r WHERE  r.amountOfRoom like ? AND r.HotelID = h.HotelID AND r.kindID = k.kindID";
    public List<HotelDTO> getHotelByName(String searchValue)
        throws SQLException, ClassNotFoundException{
        List<HotelDTO> listHotels = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                stm = con.prepareStatement(SEARCH_BY_HOTEL_NAME);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String hotelName = rs.getString("HotelName");
                    String hotelArea = rs.getString("HotelArea");
                    String kindName = rs.getString("kindName");
                    int price = rs.getInt("price");
                    String roomID = rs.getString("RoomID");
                    String roomName = rs.getString("RoomName");
                    int amountOfRoom = rs.getInt("amountOfRoom");
                    Date checkInDate = rs.getDate("checkInDate");
                    Date checkOutDate = rs.getDate("checkOutDate");
                    listHotels.add(new HotelDTO(hotelName, hotelArea, kindName, roomID, roomName, price, checkInDate, checkOutDate, amountOfRoom));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listHotels;
    }
    
    public List<HotelDTO> getHotelByArea(String searchValue)
        throws SQLException, ClassNotFoundException{
        List<HotelDTO> listHotels = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                stm = con.prepareStatement(SEARCH_BY_HOTEL_AREA);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String hotelName = rs.getString("HotelName");
                    String hotelArea = rs.getString("HotelArea");
                    String kindName = rs.getString("kindName");
                    int price = rs.getInt("price");
                    String roomID = rs.getString("RoomID");
                    String roomName = rs.getString("RoomName");
                    int amountOfRoom = rs.getInt("amountOfRoom");
                    Date checkInDate = rs.getDate("checkInDate");
                    Date checkOutDate = rs.getDate("checkOutDate");
                    listHotels.add(new HotelDTO(hotelName, hotelArea, kindName, roomID, roomName, price, checkInDate, checkOutDate, amountOfRoom));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listHotels;
    }
    
    public List<HotelDTO> getHotelByCheckInDate(String searchValue)
        throws SQLException, ClassNotFoundException{
        List<HotelDTO> listHotels = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                stm = con.prepareStatement(SEARCH_BY_HOTEL_CHECKINDATE);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String hotelName = rs.getString("HotelName");
                    String hotelArea = rs.getString("HotelArea");
                    String kindName = rs.getString("kindName");
                    int price = rs.getInt("price");
                    String roomID = rs.getString("RoomID");
                    String roomName = rs.getString("RoomName");
                    int amountOfRoom = rs.getInt("amountOfRoom");
                    Date checkInDate = rs.getDate("checkInDate");
                    Date checkOutDate = rs.getDate("checkOutDate");
                    listHotels.add(new HotelDTO(hotelName, hotelArea, kindName, roomID, roomName, price, checkInDate, checkOutDate, amountOfRoom));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listHotels;
    }
    
    public List<HotelDTO> getHotelByCheckOutDate(String searchValue)
        throws SQLException, ClassNotFoundException{
        List<HotelDTO> listHotels = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                stm = con.prepareStatement(SEARCH_BY_HOTEL_CHECKOUTDATE);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String hotelName = rs.getString("HotelName");
                    String hotelArea = rs.getString("HotelArea");
                    String kindName = rs.getString("kindName");
                    int price = rs.getInt("price");
                    String roomID = rs.getString("RoomID");
                    String roomName = rs.getString("RoomName");
                    int amountOfRoom = rs.getInt("amountOfRoom");
                    Date checkInDate = rs.getDate("checkInDate");
                    Date checkOutDate = rs.getDate("checkOutDate");
                    listHotels.add(new HotelDTO(hotelName, hotelArea, kindName, roomID, roomName, price, checkInDate, checkOutDate, amountOfRoom));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listHotels;
    }
    public List<HotelDTO> getHotelByAmountOfRoom(int searchValue)
        throws SQLException, ClassNotFoundException{
        List<HotelDTO> listHotels = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                stm = con.prepareStatement(SEARCH_BY_HOTEL_AMOUNTOFROOM);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String hotelName = rs.getString("HotelName");
                    String hotelArea = rs.getString("HotelArea");
                    String kindName = rs.getString("kindName");
                    int price = rs.getInt("price");
                    String roomID = rs.getString("RoomID");
                    String roomName = rs.getString("RoomName");
                    int amountOfRoom = rs.getInt("amountOfRoom");
                    Date checkInDate = rs.getDate("checkInDate");
                    Date checkOutDate = rs.getDate("checkOutDate");
                    listHotels.add(new HotelDTO(hotelName, hotelArea, kindName, roomID, roomName, price, checkInDate, checkOutDate, amountOfRoom));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listHotels;
    }
}
