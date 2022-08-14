/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.login;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class UserDTO implements Serializable{
    private String email;
    private String password;
    private String name;
    private String address;
    private Date createdate;
    private String roleID;
    private boolean status;
    private String phone;

    public UserDTO(String email, String name, String roleID, boolean status) {
        this.email = email;
        this.name = name;
        this.roleID = roleID;
        this.status = status;
    }

    public UserDTO(String email, String password, String name, String address, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.createdate = Date.valueOf("2022-04-25");
        this.roleID = "US";
        this.status = true;
        this.phone = phone;
    }
    
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
    
}
