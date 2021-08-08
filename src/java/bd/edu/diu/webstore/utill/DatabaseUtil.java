/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.utill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class DatabaseUtil {
    public static void dml(String sqlDML) throws SQLException {
        Statement stm=DButill.getCon().createStatement();
        stm.executeUpdate(sqlDML);
        stm.close();
    }
    
    public static ResultSet select(String query) throws SQLException {
        return DButill.getCon().createStatement().executeQuery(query);
    }
}
