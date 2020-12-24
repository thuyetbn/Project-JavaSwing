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
import javax.swing.JOptionPane;
import model.Account;
import model.Mark;

/**
 *
 * @author BinDz
 */
public class MarkDAO {
    Connection conn;

    public MarkDAO() {
        this.conn = BConnection.getConnection();
    }
    
    public List<Mark> getAllMark() {
        List<Mark> lstm = new ArrayList<>();
        String sql = "{CALL getAllMark}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int Student_ID = rs.getInt("Student_ID");
                int MonHoc_ID = rs.getInt("MonHoc_ID");
                int Diem = rs.getInt("Diem");
                String Ex_Date = rs.getString("Ex_Date");
                int Status = rs.getInt("Status");
                String Note = rs.getString("Note");
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem,Status, Note,Ex_Date));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lstm;
    }
    public List<Mark> findStudentMark(String name1) {
        List<Mark> lstm = new ArrayList<>();
        String sql = "{call findStudentMark(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, name1);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int Student_ID = rs.getInt("Student_ID");
                int MonHoc_ID = rs.getInt("MonHoc_ID");
                int Diem = rs.getInt("Diem");
                String Ex_Date = rs.getString("Ex_Date");
                int Status = rs.getInt("Status");
                String Note = rs.getString("Note");
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem,Status, Note,Ex_Date));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lstm;
    }
    
    
    
    
}
