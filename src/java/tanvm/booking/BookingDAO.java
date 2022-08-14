/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.booking;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tanvm.login.UserDTO;
import tanvm.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class BookingDAO implements Serializable{
    public boolean createBookingOrder(BookingDTO dto)
            throws SQLException, ClassNotFoundException {
        boolean order = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
               String sql = "Insert Into tblBooking("
                        + "BookingID, HotelName, amount, CheckInDate, CheckOutDate, roomID, price, email"
                        + ") Values (?, ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookingID());
                stm.setString(2, dto.getHotelName());
                stm.setInt(3, dto.getAmount());
                stm.setDate(4, dto.getCheckInDate());
                stm.setDate(5, dto.getCheckOutDate());
                stm.setString(6, dto.getRoomID());
                stm.setInt(7, dto.getPrice());
                stm.setString(8, dto.getEmail());
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    order = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return order;
    }
}
