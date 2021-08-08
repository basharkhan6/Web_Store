/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.edu.diu.webstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface WebStoreDAO<T> {
    public void save(T value) throws SQLException;
    public void update(T value) throws SQLException;
    public void delete(T value) throws SQLException;
    
    public T find(int value) throws SQLException;
    public ArrayList<T> getAll() throws SQLException;

}
