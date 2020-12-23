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
import model.KhoaHoc;
/**
 *
 * @author BinDz
 */
public class KhoaHocDAO {
    Connection conn;

    public KhoaHocDAO() {
        this.conn = BConnection.getConnection();
    }
    
    public List<KhoaHoc> getAllKhoaHoc(){
        List<KhoaHoc> lh = new ArrayList<>();
        String sql = "select * from tbl_KhoaHoc ";
        try {
            PreparedStatement PS = conn.prepareCall(sql);
            ResultSet rs =PS.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String begin_date = rs.getString("Begin_date");
                String end_date = rs.getString("End_data");
                lh.add(new KhoaHoc(id, name,begin_date , end_date));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lh;
    }
}
