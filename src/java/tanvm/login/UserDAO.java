/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.login;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tanvm.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class UserDAO implements Serializable{
    private static final String LOGIN = "SELECT name, roleID FROM tblUsers WHERE email = ? AND password = ? AND status = 1";
    public UserDTO checkLogin(String userID, String password)
            throws SQLException, ClassNotFoundException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
               
                stm = con.prepareStatement(LOGIN);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("name");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, true);
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
        return user;
    }
}
