/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanvm.registration;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import tanvm.login.UserDTO;
import tanvm.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class RegistrationDAO implements Serializable {
    public boolean createNewAccount(UserDTO dto) throws SQLException, ClassNotFoundException {
        if (dto == null) {
            return false;
        }
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert Into tblUsers("
                        + "email, password, name, address, createdate, status, roleID, phone"
                        + ") Values (?, ?, ?, ?, ?, ?, ?, ?)";
                //3. Create Statement Object
                
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getName());
                stm.setString(4, dto.getAddress());
                stm.setDate(5, Date.valueOf("2022-04-27"));
                stm.setBoolean(6, true);
                stm.setString(7, "US");
                stm.setString(8, dto.getPhone());
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    return true;

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
        return false;
    }
}