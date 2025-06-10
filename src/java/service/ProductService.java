/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.List;
import model.Product;
import productDAO.ProductDAO;

/**
 *
 * @author LAPTOP
 */
public class ProductService implements IProductService{
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    public  ProductService(){
        this.productDAO = new ProductDAO();
    }
    @Override
    public void createProduct(Product product) throws SQLException{
        productDAO.insertProduct(product);
    }
    
    @Override
    public Product getProductById(int id){
        return productDAO.selectProduct(id);
    }
    
    @Override
    public List<Product> getAllProducts(){
        return productDAO.selectAllProducts();
    }
    @Override
    public boolean removeProduct(int id)throws SQLException{
        return productDAO.deleteProduct(id);
    }
    @Override
    public boolean updateProduct(Product product) throws  SQLException{
        return productDAO.updateProduct(product);
    }
}
