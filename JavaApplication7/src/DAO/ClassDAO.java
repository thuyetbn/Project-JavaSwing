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
import model.ClassRoom;
/**
 *
 * @author BinDz
 */
public class ClassDAO {

    Connection conn;

    public ClassDAO() {
        this.conn = BConnection.getConnection();
    }
    
    public List<ClassRoom> getAllClass(){
        List<ClassRoom> LC = new ArrayList<>();
        String sql = "{CALL getAllClass}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs =cs.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int khoahoc_id = rs.getInt("KhoaHoc_ID");
                int giaovien_id = rs.getInt("GiaoVien_ID");
                String giaovien = rs.getString("Teacher_Name");
                String khoahoc = rs.getString("KH_Name");
                LC.add(new ClassRoom(id, name, khoahoc_id, giaovien_id,khoahoc,giaovien));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LC;
    }
    
    public int addClassRoom(ClassRoom c) {
        int row = 0;
        String sql = "{CALL addClassRoom(?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, c.getName());
            cs.setInt(2, c.getKH_id());
            cs.setInt(3, c.getTeacher_id());;
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    public int updateClassRoom(ClassRoom c) {
        int row = 0;
        String sql = "{CALL updateClassRoom(?,?,?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, c.getId());
            cs.setString(2, c.getName());
            cs.setInt(3, c.getKH_id());
            cs.setInt(4, c.getTeacher_id());
            row = cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

}
