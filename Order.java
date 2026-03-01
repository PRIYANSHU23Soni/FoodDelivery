package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private Deliveryperson deliveryPerson;

    // Constructor
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>(customer.getCart().getItems());
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void assignDeliveryperson(Deliveryperson dp) {
        this.deliveryPerson = dp;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer: " + customer.getusername() +
               ", Status: " + status +
               ", Delivery Person: " +
               (deliveryPerson == null ? "Not Assigned" : deliveryPerson.getName());
    }
}
