package com.tns.fooddeliverysystem.application;

import java.util.Scanner;
import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.*;

public class FoodDeliverySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        int choice;

        do {
            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminMenu(sc, restaurantService, orderService);
                    break;

                case 2:
                    customerMenu(sc, customerService, restaurantService, orderService);
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }

    // ================= ADMIN MENU =================
    private static void adminMenu(Scanner sc,
                                  RestaurantService restaurantService,
                                  OrderService orderService) {

        int choice;

        do {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. View Restaurants");
            System.out.println("4. Add Delivery Person");
            System.out.println("5. Assign Delivery Person");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Restaurant ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Restaurant Name: ");
                    String rname = sc.nextLine();

                    restaurantService.addRestaurant(new Restaurant(rid, rname));
                    System.out.println("Restaurant added successfully!");
                    break;

                case 2:
                    System.out.print("Restaurant ID: ");
                    int restId = sc.nextInt();

                    Restaurant restaurant = restaurantService.getRestaurantById(restId);

                    if (restaurant != null) {
                        System.out.print("Food ID: ");
                        int fid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Food Name: ");
                        String fname = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        restaurant.addFoodItem(new FoodItem(fid, fname, price));
                        System.out.println("Food item added!");
                    } else {
                        System.out.println("Restaurant not found!");
                    }
                    break;

                case 3:
                    for (Restaurant r : restaurantService.getAllRestaurants()) {
                        System.out.println(r);
                        for (FoodItem f : r.getMenu()) {
                            System.out.println("   " + f);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Delivery Person ID: ");
                    int dpId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String dpName = sc.nextLine();
                    System.out.print("Contact No: ");
                    long contact = sc.nextLong();

                    orderService.addDeliveryperson(
                            new Deliveryperson(dpId, dpName, contact));
                    System.out.println("Delivery person added!");
                    break;

                case 5:
                    System.out.print("Order ID: ");
                    int orderId = sc.nextInt();
                    System.out.print("Delivery Person ID: ");
                    int deliveryId = sc.nextInt();

                    orderService.assignDelivery(orderId, deliveryId);
                    System.out.println("Delivery person assigned!");
                    break;
            }

        } while (choice != 6);
    }

    // ================= CUSTOMER MENU =================
    private static void customerMenu(Scanner sc,
                                     CustomerService customerService,
                                     RestaurantService restaurantService,
                                     OrderService orderService) {

        int choice;

        do {
            System.out.println("\n--- CUSTOMER MENU ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Restaurants");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Contact No: ");
                    long contact = sc.nextLong();

                    customerService.addCustomer(
                            new Customer(cid, cname, contact));
                    System.out.println("Customer added!");
                    break;

                case 2:
                    for (Restaurant r : restaurantService.getAllRestaurants()) {
                        System.out.println(r);
                        for (FoodItem f : r.getMenu()) {
                            System.out.println("   " + f);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Customer ID: ");
                    int customerId = sc.nextInt();
                    Customer customer =
                            customerService.getCustomerById(customerId);

                    if (customer != null) {

                        System.out.print("Restaurant ID: ");
                        int restId = sc.nextInt();
                        Restaurant restaurant =
                                restaurantService.getRestaurantById(restId);

                        if (restaurant != null) {

                            System.out.print("Food ID: ");
                            int foodId = sc.nextInt();
                            System.out.print("Quantity: ");
                            int qty = sc.nextInt();

                            for (FoodItem f : restaurant.getMenu()) {
                                if (f.getid() == foodId) {
                                    customer.getCart().addItem(f, qty);
                                    System.out.println("Added to cart!");
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Customer ID: ");
                    int cId = sc.nextInt();
                    Customer cust =
                            customerService.getCustomerById(cId);

                    if (cust != null) {
                        cust.getCart().displayCart();
                    }
                    break;

                case 5:
                    System.out.print("Customer ID: ");
                    int placeId = sc.nextInt();
                    Customer custOrder =
                            customerService.getCustomerById(placeId);

                    if (custOrder != null) {
                        Order order = new Order(
                                orderService.getAllOrders().size() + 1,
                                custOrder);

                        orderService.placeOrder(order);
                        custOrder.getCart().clearCart();
                        System.out.println("Order placed successfully!");
                    }
                    break;

                case 6:
                    for (Order o : orderService.getAllOrders()) {
                        System.out.println(o);
                    }
                    break;
            }

        } while (choice != 7);
    }
}
