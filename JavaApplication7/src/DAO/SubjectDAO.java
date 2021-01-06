/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import model.Subject;

/**
 *
 * @author BinDz
 */
public class SubjectDAO {
    Connection conn;
    
    public SubjectDAO(){
        this.conn = BConnection.getConnection();
    }
    
    public List<Subject> getAllSubject() {
        List<Subject> lsts = new ArrayList<>();
        String sql = "{call getAllSubject}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int credits = rs.getInt("credits");
                int status = rs.getInt("Status");
                int KH_ID = rs.getInt("KhoaHoc_ID");
                String KH_Name = rs.getString("KH_Name");
                lsts.add(new Subject(id, name,credits,status,KH_ID,KH_Name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsts;
    }
    public int addSubject(Subject s) {
        int row = 0;
        String sql = "{CALL insertSubject(?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, s.getName());
            cs.setInt(2, s.getCredits());
            cs.setInt(3, s.getStatus());
            cs.setInt(4, s.getKH_ID());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    } 
    public int updateSubject(Subject s) {
        int row = 0;
        String sql = "{CALL updateSubject(?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, s.getId());
            cs.setString(2, s.getName());
            cs.setInt(3, s.getCredits());
            cs.setInt(4, s.getStatus());
            cs.setInt(5, s.getKH_ID());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    } 
    
    public List<Subject> findSubject(String name1) {
        List<Subject> lsts = new ArrayList<>();
        String sql = "{call findSubject(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, name1);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int credits = rs.getInt("credits");
                int status = rs.getInt("Status");
                int KH_ID = rs.getInt("KhoaHoc_ID");
                String KH_Name = rs.getString("KH_Name");
                lsts.add(new Subject(id, name,credits,status,KH_ID,KH_Name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsts;
    }
    public boolean delete(int id) {
        boolean check = false;
        String sql = "{CALL deleteSubject(?)}";
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
}
