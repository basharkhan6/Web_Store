/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.dao;

import bd.edu.diu.webstore.model.Customer;
import bd.edu.diu.webstore.utill.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CustomerDAOimplement implements WebStoreDAO<Customer>{

    @Override
    public void save(Customer value) throws SQLException {
        String sql="INSERT INTO customers(cName, phone, email, address) "
                + "VALUES ('"+value.getcName()+"', '"+value.getPhone()+"', '"+value.getEmail()+"', '"+value.getAddress()+"')";
        DatabaseUtil.dml(sql);
    }

    @Override
    public void update(Customer value) throws SQLException {
        String sql="UPDATE customers SET cName='"+value.getcName()+"', phone='"+value.getPhone()+"', email='"+value.getEmail()+"', address='"+value.getAddress()
                +"' WHERE cID="+value.getcID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public void delete(Customer value) throws SQLException {
        String sql="DELETE FROM customers WHERE cID="+value.getcID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public Customer find(int value) throws SQLException {
        String sql="SELECT * FROM customers WHERE cID="+value;
        ResultSet rs=DatabaseUtil.select(sql);
        if(rs.next()){
            Customer customer=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            return customer;
        }      
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        String sql="SELECT * FROM customers";
        ResultSet rs=DatabaseUtil.select(sql);
        ArrayList<Customer> customers=new ArrayList<>();
        while(rs.next()){
            Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            customers.add(customer);
        }
        return customers;
    }
   
}
