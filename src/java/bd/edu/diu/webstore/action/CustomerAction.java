/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.action;

import bd.edu.diu.webstore.dao.CustomerDAOimplement;
import bd.edu.diu.webstore.model.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class CustomerAction implements Action{   
    CustomerDAOimplement dao=new CustomerDAOimplement();
    ArrayList<Customer> al = new ArrayList<>();
    Customer customer;
    
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(request.getParameter("input") != null){
            return "/customer/entry.jsp";
        }
        if(request.getParameter("btnSave") != null){
            String name = request.getParameter("cName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            
            Customer customer = new Customer(0, name, phone, email, address);
            try {
                dao.save(customer);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(request.getParameter("edit") != null){
            try {
                customer=dao.find(Integer.parseInt(request.getParameter("edit")));
                request.getSession().setAttribute("customer", customer);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "/customer/edit.jsp";
        }
        if(request.getParameter("btnUpdate") != null){
            int cID = Integer.parseInt(request.getParameter("cID"));
            String cName = request.getParameter("cName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            
            Customer customer=new Customer(cID, cName, phone, email, address);
            try {
                dao.update(customer);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(request.getParameter("delete") != null){
            int cID=Integer.parseInt(request.getParameter("delete"));
            Customer customer = new Customer();
            customer.setcID(cID);
            try {
                dao.delete(customer);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        try {
            al=dao.getAll();
            request.getSession().setAttribute("customers", al);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/customer/list.jsp";        
    }
    
}
