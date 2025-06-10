/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Product;
import java.sql.SQLException;

/**
 *
 * @author LAPTOP
 */
public interface IProductService {
    void createProduct(Product product) throws SQLException;
    Product getProductById(int id);
    List<Product> getAllProducts();
    boolean removeProduct(int id)throws SQLException;
    boolean updateProduct(Product product) throws SQLException;
}
