/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.booking;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class BookingDTO implements Serializable{
    private String BookingID;
    private String HotelName;
    private int amount;
    private Date CheckInDate;
    private Date CheckOutDate;
    private String roomID;
    private int price;
    private String email;

    public BookingDTO(String BookingID, String HotelName, int amount, Date CheckInDate, Date CheckOutDate, String roomID, int price, String email) {
        this.BookingID = BookingID;
        this.HotelName = HotelName;
        this.amount = amount;
        this.CheckInDate = CheckInDate;
        this.CheckOutDate = CheckOutDate;
        this.roomID = roomID;
        this.price = price;
        this.email = email;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(Date CheckInDate) {
        this.CheckInDate = CheckInDate;
    }

    public Date getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(Date CheckOutDate) {
        this.CheckOutDate = CheckOutDate;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
