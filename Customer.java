package com.tns.fooddeliverysystem.entities;

public class Customer extends User {

    private Cart cart;

    // Constructor
    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);  // calling parent constructor
        this.cart = new Cart();              // creating cart for customer
    }

    // Getter for cart
    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer ID: " + getuserId() +
               ", Name: " + getusername();
    }
}
