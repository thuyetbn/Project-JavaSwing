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
                lsta.add(new Account(id, name, phone, email, pass, address, birthday, status, role_id, role_name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsta;
    }

    public int addAccount(Account a) {
        int row = 0;
        String sql = "{CALL insertAccount(?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, a.getName());
            cs.setString(2, a.getPhone());
            cs.setString(3, a.getEmail());
            cs.setString(4, a.getPassword());
            cs.setString(5, a.getAddress());
            cs.setString(6, a.getBirthday());
            cs.setInt(7, a.getStatus());
            cs.setInt(8, a.getRole_ID());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public int updateAccount(Account a) {
        int row = 0;
        String sql = "{CALL updateAccount(?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, a.getId());
            cs.setString(2, a.getName());
            cs.setString(3, a.getPhone());
            cs.setString(4, a.getEmail());
            cs.setString(5, a.getPassword());
            cs.setString(6, a.getAddress());
            cs.setString(7, a.getBirthday());
            cs.setInt(8, a.getStatus());
            cs.setInt(9, a.getRole_ID());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    
    public boolean delete(int id) {
        boolean check = false;
        String sql = "{CALL deleteAccount(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            int result = cs.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public List<Account> findAccount(String name1) {
        List<Account> lsta = new ArrayList<>();
        String sql = "{call findAccount(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, name1);
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
                lsta.add(new Account(id, name, phone, email, pass, address, birthday, status, role_id, role_name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsta;
    }

}
