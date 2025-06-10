/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.List;
import model.User;

/**
 *
 * @author LAPTOP
 */
public interface  IUserService {
    void createUser(User user) throws SQLException;
    User getUserById(int id);
    List<User> getAllUsers();
    boolean removeUser(int id)throws SQLException;
    boolean updateUser(User user) throws SQLException;
    User checkLogin(String name, String password) throws SQLException;
}
