/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tanvm.booking.BookingDTO;

/**
 *
 * @author ASUS
 */
public class CartObject implements Serializable{
    private Map<String, BookingDTO> items;
    
    public CartObject() {
    }

    public Map<String, BookingDTO> getItems() {
        return items;
    }
    
    public void addItemToCart(BookingDTO id) {
        //1. check available items
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        int quantity = 1;
         
        if (this.items.containsKey(id.getBookingID())) {
            quantity = this.items.get(id.getBookingID()).getAmount() + 1;
            this.items.get(id.getBookingID()).setAmount(quantity);
        }

        this.items.put(id.getBookingID(), id);
    }
    public void removeItemFromCart (String id) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(id)){
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    public void updateAmountOfItem (String id, int amount) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(id)){
            this.items.get(id).setAmount(amount);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
