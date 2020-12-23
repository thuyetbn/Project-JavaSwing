/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Class;
/**
 *
 * @author BinDz
 */
public class ClassDAO {

    Connection conn;

    public ClassDAO() {
        this.conn = BConnection.getConnection();
    }
    
    public List<Class> getAllClass(){
        List<Class> LC = new ArrayList<>();
        String sql = "select * from tbl_Class ";
        try {
            PreparedStatement PS = conn.prepareCall(sql);
            ResultSet rs =PS.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int khoahoc_id = rs.getInt("KhoaHoc_ID");
                int giaovien_id = rs.getInt("GiaoVien_ID");
                LC.add(new Class(id, name, khoahoc_id, giaovien_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LC;
    }

}
