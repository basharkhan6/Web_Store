/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TestJDBC {
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/test";
        String uName="root";
        String uPass="";
        Connection con = null;
        /*        String sql="CREATE TABLE users(userID int PRIMARY KEY AUTO_INCREMENT, userName VARCHAR(20), password VARCHAR(15))";*/        String driver="com.mysql.jdbc.Driver";
        /*        String sql="INSERT INTO users VALUES (1004, 'Bashar4', 'Tisha')";*/
        String sql="SELECT * FROM users WHERE userID=1002";
                
        try {
            Class.forName(driver);  //load driver
            con=DriverManager.getConnection(URL, uName, uPass);
            
            /*Statement stm=con.createStatement();
            
            
            PreparedStatement pstm=con.prepareStatement("SELECT * FROM users WHERE userID=?");
            pstm.setInt(1, 1003);*/
            PreparedStatement pstm=con.prepareStatement("UPDATE users SET userName=?, password=? WHERE userID=?");
            pstm.setString(1, "Tisha");
            pstm.setString(2, "MeUpdated");
            pstm.setInt(3, 1005);
            
            pstm.executeUpdate();
            
            
            /*            stm.executeUpdate(sql);*/  //executeUpdate only for DDL/DDML
            
            /*            ResultSet rs=stm.executeQuery(sql);*/

            
            /*ResultSet rs=pstm.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();
            
            for(int i=1; i<=rsm.getColumnCount(); i++){
            System.out.print(rsm.getColumnName(i)+"  ");
            }
            System.out.println();
            while(rs.next()){
            System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getString("password"));
            }*/
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
