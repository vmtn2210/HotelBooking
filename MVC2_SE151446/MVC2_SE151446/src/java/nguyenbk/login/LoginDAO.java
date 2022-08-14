/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenbk.login;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nguyenbk.utils.DBHelper;

/**
 *
 * @author buikh
 */
public class LoginDAO implements Serializable{
    private List<LoginDTO> accounts;
    
    public LoginDTO checkLogin(String username, String password)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "Select username, password, lastname, isAdmin "
                    + "FROM dbo.Login "
                    + "WHERE username = ? "
                    + "AND password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if(rs.next()){
                    String dtoUsername = rs.getString("username");
                    String dtoPassword = rs.getString("password");
                    String dtoLastname = rs.getString("lastname");
                    boolean dtoIsRole = rs.getBoolean("isAdmin");
                    LoginDTO dto = new LoginDTO(dtoUsername, dtoPassword, dtoLastname, dtoIsRole);
                    return dto;
                }
            }
            
            
        }finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return null;
    }
    
    public List<LoginDTO> getAccounts() {
        return accounts;
    }
    
    public void searchLastname(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "Select username, password, lastname, isAdmin "
                        + "From TblLoginDAO "
                        + "Where lastname like ?";
                //3.Create statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4.Execute Statement to get Result
                rs = stm.executeQuery();
                //5.Process Result
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    LoginDTO dto = new LoginDTO(username,
                            password, fullname, role);

                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }//end create new List
                    this.accounts.add(dto);
                }//End traverse Result Set
            }//end if connection has opened
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
    }
    
    public boolean deleteAccount(String username)
          throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "Delete From TblLoginDAO "
                        + "Where username = ?";
                //3.Create statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Execute Statement to get Result
                int row = stm.executeUpdate();
                //5.Process Result
                if(row > 0){
                    return true;
                }
            }//end if connection has opened
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateAccount(String username, String password, boolean role)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "Update TblLoginDAO "
                        + "Set password = ? "
                        + ",isAdmin = ? "
                        + "Where username = ?";
                //3.Create statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                //4.Execute Statement to get Result
                int row = stm.executeUpdate();
                //5.Process Result
                if(row > 0){
                    return true;
                }
            }//end if connection has opened
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean createNewAccount(LoginDTO dto)
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect to DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "Insert Into TblLoginDAO("
                        + "username, password, lastname, isAdmin"
                        + ") Values (?, ?, ?, ?)";
                //3.Create statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setBoolean(4, dto.isRole());
                //4.Execute Statement to get Result
                int row = stm.executeUpdate();
                //5.Process Result
                if(row > 0){
                    return true;
                }
            }//end if connection has opened
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
}
