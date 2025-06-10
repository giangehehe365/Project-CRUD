/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LAPTOP
 */
public class Product {
    private int id;
    private String name;
    private double price;
    
    private String description;
    private int stock;
    
   
    public Product(int id, String name, double price,  String description, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
   
        this.description = description;
        this.stock = stock;
    }
     
     public Product( String name, double price, String description, int stock) {
        
        this.name = name;
        this.price = price;
        
        this.description = description;
        this.stock = stock;
    }

   
   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Example to display product information
    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price 
                + ", Description: " + description + ", Stock: " + stock;
    }
}
