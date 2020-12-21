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
import model.Role;
/**
 *
 * @author BinDz
 */
public class RoleDAO {
    Connection conn;

    public RoleDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Role> get(){
        List<Role> lr = new ArrayList<>();
        String sql = "{call getAllRole}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                lr.add(new Role(id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
}
