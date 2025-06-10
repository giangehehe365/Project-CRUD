/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productDAO;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author LAPTOP
 */
public class ProductDAO implements IProductDAO{
    private static final String INSERT_PRODUCT = "INSERT INTO Product (name, price, description, stock) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM Product WHERE id = ?";
    private static final String UPDATE_PRODUCT = "UPDATE Product SET name = ?, price = ?, description = ?, stock = ? WHERE id = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM Product";


    @Override
    public void insertProduct(Product pro) throws SQLException {
        try(Connection conn = DBConnection.getConnection()) {
            if(conn!=null){

                PreparedStatement ps = conn.prepareStatement(INSERT_PRODUCT);
                ps.setString(1, pro.getName());
                ps.setDouble(2, pro.getPrice());
                ps.setString(3, pro.getDescription());
                ps.setInt(4, pro.getStock());
                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        }
        }catch (Exception e) {
            e.printStackTrace();
        }    
    }

    @Override
    public Product selectProduct(int id) {
        Product pro = null;  
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(SELECT_PRODUCT_BY_ID);
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        pro = new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),

                            rs.getString("description"),
                            rs.getInt("stock")

                        );

                        System.out.println("User found: " );
                    } else {
                        System.out.println("User not found!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return pro;  
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();  

        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_PRODUCTS);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    products.add(new Product(id, name, price, description, stock));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products; 
    }


    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted = false;
        String DELETE_PRODUCT = "DELETE FROM Product WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_PRODUCT)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;  
            if (rowDeleted) {
                System.out.println("Product with ID " + id + " deleted from DB.");
            } else {
                System.out.println("No product found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


        @Override

    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated = false;
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT);
                ps.setString(1, product.getName());
                ps.setDouble(2, product.getPrice());
                ps.setString(3, product.getDescription());
                ps.setInt(4, product.getStock());
                ps.setInt(5, product.getId());  
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    rowUpdated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
