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
                lsts.add(new Subject(id, name,credits,status));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsts;
    }
    public int addSubject(Subject s) {
        int row = 0;
        String sql = "{CALL insertSubject(?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, s.getName());
            cs.setInt(2, s.getCredits());
            cs.setInt(3, s.getStatus());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    } 
}
