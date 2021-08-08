/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.dao;

import bd.edu.diu.webstore.model.Order;
import bd.edu.diu.webstore.utill.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bashar
 */
public class OrderDAOimplement implements WebStoreDAO<Order>{

    @Override
    public void save(Order value) throws SQLException {
        String sql="INSERT INTO orders(cID, orderDate, orderType, amount, discount, tax) "
                + "VALUES ("+value.getcID()+", "+value.getOrderDate()+", '"+value.getOrderType()+"', "+value.getAmount()+", "+value.getDiscount()+", "+value.getTax()+")";
        DatabaseUtil.dml(sql);
    }

    @Override
    public void update(Order value) throws SQLException {
        String sql="UPDATE orders SET cID="+value.getcID()+", orderDate="+value.getOrderDate()+", orderType='"+value.getOrderType()+"', amount="+value.getAmount()
                +", discount="+value.getDiscount()+", tax="+value.getTax()+" WHERE orderID="+value.getOrderID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public void delete(Order value) throws SQLException {
        String sql="DELETE FROM orders WHERE orderID="+value.getOrderID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public Order find(int value) throws SQLException {
        String sql="SELECT * FROM orders WHERE orderID="+value;
        ResultSet rs = DatabaseUtil.select(sql);
        if(rs.next()){
            Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
            return order;
        }
        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        String sql="SELECT * FROM orders";
        ResultSet rs = DatabaseUtil.select(sql);
        ArrayList<Order> orders = new ArrayList<>();
        while(rs.next()){
            Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
            orders.add(order);
        }
        return orders;
    }
    
}
