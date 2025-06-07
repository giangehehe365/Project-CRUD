/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.User;
import userDAO.UserDAO;

/**
 *
 * @author LAPTOP
 */
public class MainTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ USER MANAGEMENT TEST ------");
            System.out.println("1. Create User");
            System.out.println("2. List All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            try {
                switch (choice) {
                    case 1: // Create
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Country: ");
                        String country = scanner.nextLine();
                        System.out.print("Role (User/Admin): ");
                        String role = scanner.nextLine();
                        System.out.print("Status (1=Active, 0=Inactive): ");
                        boolean status = scanner.nextInt() == 1;
                        scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        System.out.print("DOB (yyyy-MM-dd): ");
                        String dobStr = scanner.nextLine();
                        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);

                        User newUser = new User(name, email, country, role, status, password, dob);
                        userDAO.insertUser(newUser);
                        break;

                    case 2: // Read all
                        List<User> users = userDAO.selectAllUsers();
                        System.out.println("------ All Users ------");
                        for (User u : users) {
                            System.out.println(u);
                        }
                        break;

                    case 3: // Update
                        System.out.print("Enter User ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        User existingUser = userDAO.selectUser(updateId);
                        if (existingUser == null) {
                            System.out.println("User not found!");
                            break;
                        }
                        System.out.print("New Name: ");
                        existingUser.setName(scanner.nextLine());
                        System.out.print("New Email: ");
                        existingUser.setEmail(scanner.nextLine());
                        System.out.print("New Country: ");
                        existingUser.setCountry(scanner.nextLine());
                        System.out.print("New Role: ");
                        existingUser.setRole(scanner.nextLine());
                        System.out.print("New Status (1=Active, 0=Inactive): ");
                        existingUser.setStatus(scanner.nextInt() == 1);
                        scanner.nextLine();
                        System.out.print("New Password: ");
                        existingUser.setPassword(scanner.nextLine());
                        System.out.print("New DOB (yyyy-MM-dd): ");
                        existingUser.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));

                        boolean updated = userDAO.updateUser(existingUser);
                        System.out.println(updated ? "User updated!" : "Failed to update.");
                        break;

                    case 4: // Delete
                        System.out.print("Enter User ID to delete: ");
                        int deleteId = scanner.nextInt();
                        boolean deleted = userDAO.deleteUser(deleteId);
                        System.out.println(deleted ? "User deleted!" : "User not found or deletion failed.");
                        break;

                    case 5:
                        System.out.println("Exiting program.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
