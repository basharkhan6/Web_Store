/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.dao;

import bd.edu.diu.webstore.model.Product;
import bd.edu.diu.webstore.utill.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ProductDAOimplement implements WebStoreDAO<Product>{

    @Override
    public void save(Product value) throws SQLException {
        String sql="INSERT INTO products(pName, price, quantity, reorder) "
                + "VALUES ('"+value.getpName()+"', "+value.getPrice()+", "+value.getQuantity()+", "+value.getReorder()+ ")";
        DatabaseUtil.dml(sql);
    }

    @Override
    public void update(Product value) throws SQLException {
        String sql="UPDATE products SET pName='"+value.getpName()+"', price="+value.getPrice()+", quantity="+value.getQuantity()+", reorder="+value.getReorder()+
                " WHERE pID="+value.getpID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public void delete(Product value) throws SQLException {
        String sql="DELETE FROM products WHERE pID="+value.getpID();
        DatabaseUtil.dml(sql);
    }

    @Override
    public Product find(int value) throws SQLException {
        String sql="SELECT * FROM products WHERE pID="+value;
        ResultSet rs=DatabaseUtil.select(sql);
        if(rs.next()){
            Product product=new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
            return product;
        }      
        return null;
    }

    @Override
    public ArrayList<Product> getAll() throws SQLException {
        String sql="SELECT * FROM products";
        ResultSet rs=DatabaseUtil.select(sql);
        ArrayList<Product> products=new ArrayList<>();
        while(rs.next()){
            Product product=new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
            products.add(product);
        }      
        return products;
    }
    
}
