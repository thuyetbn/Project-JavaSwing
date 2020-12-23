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
import model.Student;
/**
 *
 * @author BinDz
 */
public class StudentDAO {

    Connection conn;
    ArrayList<Student> as = new ArrayList<>();

    public StudentDAO() {
        this.conn = BConnection.getConnection();
    }
    
    public List<Student> getAllStudent() {
        List<Student> lsts = new ArrayList<>();
        String sql = "{call getAllStudent}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("MaSV");
                String phone = rs.getString("Name");
                String email = rs.getString("Phone");
                String pass = rs.getString("Email");
                String address = rs.getString("Address");
                String birthday = rs.getString("Birthday");
                int gender = rs.getInt("Gender");
                int status = rs.getInt("Status");
                int class_id = rs.getInt("Class_ID");
                String class_name = rs.getString("ClassName");
                lsts.add(new Student(id, name, phone, email, pass, address, birthday, gender, status,class_id,class_name));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return lsts;
    }
    
    public int addStudent(Student s) {
        int row = 0;
        String sql = "{CALL insertStudent(?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, s.getMaSV());
            cs.setString(2, s.getName());
            cs.setString(3, s.getEmail());
            cs.setString(4, s.getPhone());
            cs.setString(5, s.getAddress());
            cs.setString(6, s.getBirthday());
            cs.setInt(7, s.getGender());
            cs.setInt(8, s.getStatus());
            cs.setInt(9, s.getClass_ID());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    } 
    public boolean delete(int id) {
        boolean check = false;
        String sql = "{CALL deleteStudent(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            int result = cs.executeUpdate();
            if(result>0){
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    } 
}
