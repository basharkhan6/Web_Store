/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.action;

import bd.edu.diu.webstore.dao.ProductDAOimplement;
import bd.edu.diu.webstore.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ProductAction implements Action{
    
    ProductDAOimplement dao = new ProductDAOimplement();
    ArrayList<Product> al = new ArrayList<>();
    Product product;
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        if(request.getParameter("input") != null){
            return "/product/entry.jsp";
        }
        if(request.getParameter("btnSave") != null){
            String pName=request.getParameter("pName");
            double price=Double.parseDouble(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            int reorder=Integer.parseInt(request.getParameter("reorder"));
            
            Product product = new Product(0, pName, price, quantity, reorder);
            
            try {
                dao.save(product);
            } catch (SQLException ex) {
                Logger.getLogger(ProductAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(request.getParameter("edit") != null){
            try {
                product=dao.find(Integer.parseInt(request.getParameter("edit")));
                request.getSession().setAttribute("product", product);
            } catch (SQLException ex) {
                Logger.getLogger(ProductAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "/product/edit.jsp";
        }
        if(request.getParameter("btnUpdate") != null){
            int pID=Integer.parseInt(request.getParameter("pID"));
            String pName=request.getParameter("pName");
            double price=Double.parseDouble(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            int reorder=Integer.parseInt(request.getParameter("reorder"));
            
            Product product = new Product(pID, pName, price, quantity, reorder);
            
            try {
                dao.update(product);
            } catch (SQLException ex) {
                Logger.getLogger(ProductAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(request.getParameter("delete") != null){
            int pID=Integer.parseInt(request.getParameter("delete"));
            Product product = new Product();
            product.setpID(pID);
            try {
                dao.delete(product);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        try {
            al=dao.getAll();
            request.getSession().setAttribute("products", al);
        } catch (SQLException ex) {
            Logger.getLogger(ProductAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "/product/list.jsp";
    }
    
}
