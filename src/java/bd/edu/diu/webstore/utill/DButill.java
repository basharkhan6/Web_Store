/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DButill {
    public static Connection con;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DButill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getCon() throws SQLException {
        String URL="jdbc:mysql://localhost:3306/WebStore";
        String uName="root";
        String uPass="";
        
        con=DriverManager.getConnection(URL, uName, uPass);
        return con;
    }
}
