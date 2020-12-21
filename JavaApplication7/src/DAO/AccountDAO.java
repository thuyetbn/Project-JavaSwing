/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO; 

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Account;

/**
 *
 * @author BinDz
 */
public class AccountDAO {
    
    Connection conn;
    ArrayList<Account> aa = new ArrayList<>();
    
    public AccountDAO() {
        this.conn = BConnection.getConnection();
    }

    public List<Account> getAllAccount1() {
        List<Account> lsta = new ArrayList<>();
        String sql = "{call dbo.getAllAccount}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String pass = rs.getString("Password");
                String address = rs.getString("Address");
                String birthday = rs.getString("Birthday");
                int status = rs.getInt("Status");
                int role_id = rs.getInt("RoleId");
                String role_name = rs.getString("RoleName");
                lsta.add(new Account(id, name, phone, email, pass, address, birthday, status, role_id,role_name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsta;
    }


}
