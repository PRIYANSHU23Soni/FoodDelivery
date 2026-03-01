package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class RestaurantService {

    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant getRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }
}
