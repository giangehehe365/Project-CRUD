/*
 * UserService.java
 */
package service;

import model.User;
import userDAO.UserDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class UserService implements IUserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public UserService() {
        this.userDAO = new UserDAO(); 
    }

    @Override
    public void createUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }
    
    @Override
    public User getUserById(int id) {
        return userDAO.selectUser(id);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }
    
    @Override
    public boolean removeUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }
    
    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }
    
    @Override
    public User checkLogin(String name, String password) throws SQLException {
        return userDAO.checkLogin(name, password);
    }
    public boolean deactivateUser(int id) throws SQLException {
        return userDAO.updateStatus(id, false);
    }

}