/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.dao;

import bd.edu.diu.webstore.model.OrderLine;
import bd.edu.diu.webstore.utill.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bashar
 */
public class OrderLineDAOimplement implements WebStoreDAO<OrderLine>{

    @Override
    public void save(OrderLine value) throws SQLException {
        String sql="INSERT INTO orderLines(orderID, pID, price, quantity, lineTotal) "
                + "VALUES ("+value.getOrderID()+", "+value.getpID()+", "+value.getPrice()+", "+value.getQuantity()+ ", "+value.getLineTotal()+")";
        DatabaseUtil.dml(sql);
    }

    @Override
    public void update(OrderLine value) throws SQLException {
        String sql="UPDATE orderLines SET orderID="+value.getOrderID()+", pID="+value.getpID()+", price="+value.getPrice()+", quantity="+value.getQuantity()
                +", lineTotal="+value.getLineTotal()+" WHERE lineID="+value.getLineID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public void delete(OrderLine value) throws SQLException {
        String sql="DELETE FROM orderLines WHERE lineID="+value.getLineID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public OrderLine find(int value) throws SQLException {
        String sql="SELECT * FROM orderLine WHERE lineID="+value;
        ResultSet rs = DatabaseUtil.select(sql);
        if(rs.next()){
            OrderLine orderLine = new OrderLine(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(5), rs.getInt(4), rs.getInt(6));
            return orderLine;
        }
        return null;
    }

    @Override
    public ArrayList<OrderLine> getAll() throws SQLException {
        String sql="SELECT * FROM orderLine";
        ResultSet rs = DatabaseUtil.select(sql);
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        if(rs.next()){
            OrderLine orderLine = new OrderLine(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(5), rs.getInt(4), rs.getInt(6));
            orderLines.add(orderLine);
        }
        return orderLines;
    }
    
}
