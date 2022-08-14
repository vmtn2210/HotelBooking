/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.user;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class HotelDTO implements Serializable{
    private String hotelID;
    private String hotelName;
    private String hotelArea;
    private String kindID;
    private String kindName;
    private String roomID;
    private String roomName;
    private int price;
    private Date checkInDate;
    private Date checkOutDate;
    private int amountOfRoom;

    public HotelDTO(String hotelName, String hotelArea, String kindName, String roomID, String roomName, int price, Date checkInDate, Date checkOutDate, int amountOfRoom) {
        this.hotelName = hotelName;
        this.hotelArea = hotelArea;
        this.kindName = kindName;
        this.roomID = roomID;
        this.roomName = roomName;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amountOfRoom = amountOfRoom;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelArea() {
        return hotelArea;
    }

    public void setHotelArea(String hotelArea) {
        this.hotelArea = hotelArea;
    }

    public String getKindID() {
        return kindID;
    }

    public void setKindID(String kindID) {
        this.kindID = kindID;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getAmountOfRoom() {
        return amountOfRoom;
    }

    public void setAmountOfRoom(int amountOfRoom) {
        this.amountOfRoom = amountOfRoom;
    }

    

    
    
    
    
}
