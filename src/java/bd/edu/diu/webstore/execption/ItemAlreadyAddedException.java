/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.execption;

import javax.servlet.ServletException;

/**
 *
 * @author Administrator
 */
public class ItemAlreadyAddedException extends ServletException {

    public ItemAlreadyAddedException() {
        super("Item Already Added.");
    }

  public   ItemAlreadyAddedException(String string) {
       super(string); //To change body of generated methods, choose Tools | Templates.
    }
    
}
