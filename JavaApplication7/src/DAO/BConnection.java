/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BinDz
 */
public class BConnection {

    private static Connection conn = null; 
  
    static
    { 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien"; 
        String user = "sa"; 
        String pass = "1234$"; 
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            conn = DriverManager.getConnection(url, user, pass); 
        } 
        catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static Connection getConnection() 
    { 
        return conn; 
    }

    
}
