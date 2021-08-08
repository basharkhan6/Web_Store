/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.controller;

import bd.edu.diu.webstore.action.Action;
import bd.edu.diu.webstore.dao.ProductDAOimplement;
import bd.edu.diu.webstore.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class WebStoreController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
        HashMap products = new HashMap();     //A Collection freamwork
        ProductDAOimplement dao = new ProductDAOimplement();
        ArrayList<Product> al = new ArrayList<>();
        try {
            al = dao.getAll();
            for (Product product : al) {
                products.put(product.getpID(), product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Product product = new Product(101, "Pencil", 5, 25, 3);
        products.put(product.getpID(), product);
        product = new Product(102, "Book", 55, 15, 4);
        products.put(product.getpID(), product);
        product = new Product(103, "Kitkat", 60, 30, 8);
        products.put(product.getpID(), product);
        product = new Product(104, "Dairy Milk", 10, 50, 10);
        /*Product product = new Product(101, "Pencil", 5, 25, 3);
        products.put(product.getpID(), product);
        product = new Product(102, "Book", 55, 15, 4);
        products.put(product.getpID(), product);
        product = new Product(103, "Kitkat", 60, 30, 8);
        products.put(product.getpID(), product);
        product = new Product(104, "Dairy Milk", 10, 50, 10);
        products.put(product.getpID(), product);*/

        getServletContext().setAttribute("products", products);  //Store HashMap to Application Context
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getPathInfo().substring(1);
        //System.out.println(path);
        path = "bd.edu.diu.webstore.action." + path;
        String viewName = "/error.jsp";
        try {
            Class c = getClass().getClassLoader().loadClass(path);
            Action action = (Action) c.newInstance();
            viewName = action.process(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(WebStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
