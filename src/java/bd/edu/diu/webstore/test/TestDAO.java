/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.test;

import bd.edu.diu.webstore.dao.ProductDAOimplement;
import bd.edu.diu.webstore.dao.WebStoreDAO;
import bd.edu.diu.webstore.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TestDAO {    
    public static void main(String[] args) {
        try {
            WebStoreDAO dao=new ProductDAOimplement();
            Product p=new Product();
            p.setpID(3);
            p.setpName("KitKat");
            p.setPrice(64);
            p.setQuantity(42);
            p.setReorder(11);
            
            //dao.save(p);
            //System.out.println(dao.getAll());
            
            /*ArrayList<Product> products=new ArrayList<>();
            products=dao.getAll();
            
            System.out.println(products.get(3).getpName());*/
            
            
            
            dao.update(p);
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
