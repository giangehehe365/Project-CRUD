/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDAO;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author LAPTOP
 */
public class UserDAO implements IUserDAO{
    private static final String INSERT_USER = "INSERT INTO Users (name, email, country, role, status, password, dob) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE Users SET name = ?, email = ?, country = ?, role = ?, status = ?, password = ?, dob = ? WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM Users";
    private static final String DELETE_USER = "DELETE FROM Users WHERE id = ?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM Users WHERE id = ?";
    private static final String LOGIN = "SELECT * FROM Users WHERE name = ? AND password = ?";

    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(INSERT_USER);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getCountry());
                ps.setString(4, user.getRole());
                ps.setBoolean(5, user.getStatus());
                ps.setString(6, user.getPassword());
                if (user.getDob() != null) {
                    ps.setDate(7, new Date(user.getDob().getTime()));
                } else {
                    ps.setNull(7, java.sql.Types.DATE);
                }
                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("country"),
                            rs.getString("role"),
                            rs.getBoolean("status"),
                            rs.getString("password"),
                            rs.getDate("dob")
                        );
                        System.out.println("User found: " + user.getName());
                    } else {
                        System.out.println("User not found!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("role"),
                        rs.getBoolean("status"),
                        rs.getString("password"),
                        rs.getDate("dob")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_USER)) {

            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;

            if (rowDeleted) {
                System.out.println("User with ID " + id + " deleted from DB.");
            } else {
                System.out.println("No user found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(UPDATE_USER);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getCountry());
                ps.setString(4, user.getRole());
                ps.setBoolean(5, user.getStatus());
                ps.setString(6, user.getPassword());
                if (user.getDob() != null) {
                    ps.setDate(7, new Date(user.getDob().getTime()));
                } else {
                    ps.setNull(7, java.sql.Types.DATE);
                }
                ps.setInt(8, user.getId());

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

    public User checkLogin(String name, String password) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(LOGIN)) {
            ps.setString(1, name);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("role"),
                        rs.getBoolean("status"),
                        rs.getString("password"),
                        rs.getDate("dob")
                    );
                }
            }
        }
        return null;
    }



}
