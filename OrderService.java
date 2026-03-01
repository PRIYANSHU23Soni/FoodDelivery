package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;
import com.tns.fooddeliverysystem.entities.*;

public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private List<Deliveryperson> deliveryPersons = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addDeliveryperson(Deliveryperson dp) {
        deliveryPersons.add(dp);
    }

    public Deliveryperson getDeliveryPersonById(int id) {
        for (Deliveryperson dp : deliveryPersons) {
            if (dp.getDeliveryPersonId() == id) {
                return dp;
            }
        }
        return null;
    }

    public void assignDelivery(int orderId, int dpId) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                Deliveryperson dp = getDeliveryPersonById(dpId);
                if (dp != null) {
                    o.assignDeliveryperson(dp);
                }
            }
        }
    }
}
