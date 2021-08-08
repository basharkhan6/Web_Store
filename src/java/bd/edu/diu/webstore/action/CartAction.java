/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.action;

import bd.edu.diu.webstore.execption.ItemAlreadyAddedException;
import bd.edu.diu.webstore.model.Cart;
import bd.edu.diu.webstore.model.Product;

import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class CartAction implements Action{

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String add = "";
        if(request.getParameter("add") != null){
            add = request.getParameter("add");
        }
        
        
        HttpSession session= request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if(cart==null){
            cart=new Cart();
            session.setAttribute("cart", cart);
        }
        if(add.equalsIgnoreCase("true")){
            addToCart(request);
        }
        
        
        
        
        return  "/cart.jsp";
    }

    private void addToCart(HttpServletRequest request) throws ItemAlreadyAddedException {
        int id=Integer.parseInt(request.getParameter("id"));
        
        Product product=(Product) ((HashMap)request.getServletContext().getAttribute("products")).get(id);
        
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        cart.addItem(product);
        
        request.getSession().setAttribute("cart", cart);
        
    }
    
}
