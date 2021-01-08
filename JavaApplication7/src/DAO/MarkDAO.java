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
    
    public int addMark(Mark s){
        int row =0;
        List<Mark> lstm = new ArrayList<>();
        String sql = "{CALL addMark(?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, s.getStudent_ID());
            cs.setInt(2, s.getSubject_ID());
            cs.setInt(3, s.getMark());
            cs.setString(4, s.getEx_date());
            cs.setString(5, s.getNote());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return row;
    }
     public boolean delete(int s_id,int sj_id) {
        boolean check = false;
        String sql = "{CALL deleteMark(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, s_id);
            cs.setInt(2, sj_id);
            int result = cs.executeUpdate();
            if (result > 0) {
                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return check;
    }
    public int updateMark(Mark s){
        int row =0;
        List<Mark> lstm = new ArrayList<>();
        String sql = "{CALL updateMark(?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, s.getStudent_ID());
            cs.setInt(2, s.getSubject_ID());
            cs.setInt(3, s.getMark());
            cs.setString(4, s.getEx_date());
            cs.setString(5, s.getNote());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return row;
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
                String S_name = rs.getString("Student_Name");
                String SJ_name = rs.getString("SJ_Name");
                int S_id = rs.getInt("Student_Id");
                int SJ_id = rs.getInt("SJ_ID");
                String S_MSV = rs.getString("S_MSV");
                int Class_Id = rs.getInt("ClassId");
                String Class_Name= rs.getString("ClassName");
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem, Note,Ex_Date,S_id,S_name,SJ_id,SJ_name,S_MSV,Class_Id,Class_Name));
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
                String S_name = rs.getString("Student_Name");
                String SJ_name = rs.getString("SJ_Name");
                int S_id = rs.getInt("Student_Id");
                int SJ_id = rs.getInt("SJ_ID");
                String S_MSV = rs.getString("S_MSV");
                int Class_Id = rs.getInt("ClassId");
                String Class_Name= rs.getString("ClassName");
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem, Note,Ex_Date,S_id,S_name,SJ_id,SJ_name,S_MSV,Class_Id,Class_Name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lstm;
    }
    public List<Mark> findStudentMark1(String name1) {
        List<Mark> lstm = new ArrayList<>();
        String sql = "{call findStudentMark1(?)}";
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
                String S_name = rs.getString("Student_Name");
                String SJ_name = rs.getString("SJ_Name");
                int S_id = rs.getInt("Student_Id");
                int SJ_id = rs.getInt("SJ_ID");
                String S_MSV = rs.getString("S_MSV");
                int Class_Id = rs.getInt("ClassId");
                String Class_Name= rs.getString("ClassName");
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem, Note,Ex_Date,S_id,S_name,SJ_id,SJ_name,S_MSV,Class_Id,Class_Name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lstm;
    }
    
    public List<Mark> findMarkBySubject(String name1) {
        List<Mark> lstm = new ArrayList<>();
        String sql = "{call filterMarkBySucject(?)}";
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
                String S_name = rs.getString("Student_Name");
                String SJ_name = rs.getString("SJ_Name");
                int S_id = rs.getInt("Student_Id");
                int SJ_id = rs.getInt("SJ_ID");
                String S_MSV = rs.getString("S_MSV");
                int Class_Id = rs.getInt("ClassId");
                String Class_Name= rs.getString("ClassName");;
                lstm.add(new Mark(Student_ID, MonHoc_ID, Diem, Note,Ex_Date,S_id,S_name,SJ_id,SJ_name,S_MSV,Class_Id,Class_Name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lstm;
    }
    
    
    
}
