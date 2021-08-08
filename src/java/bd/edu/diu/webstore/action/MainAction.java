/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class MainAction implements Action {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return  "/main.jsp";
    }
    
}
