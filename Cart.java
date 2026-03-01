package com.tns.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
private Map<FoodItem,Integer>items;

public Cart() {
	items=new HashMap<>();
	
}

public void addItem(FoodItem foodItem,int quantity) {
	if(items.containsKey(foodItem)) {
		int oldQuantity=items.get(foodItem);
		items.put(foodItem, oldQuantity+quantity);
		
	}
	else {
		items.put(foodItem, quantity);
	}
}
public void removeItem(FoodItem foodItem) {
	items.remove(foodItem);
}
public Map<FoodItem, Integer> getItems() {
    return items;
}
public void displayCart() {

    double total = 0;

    for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {

        FoodItem food = entry.getKey();
        int quantity = entry.getValue();

        double cost = food.getprice() * quantity;
        total += cost;

        System.out.println(food.gettname() + 
                           " x " + quantity + 
                           " = Rs. " + cost);
    }

    System.out.println("Total Cost: Rs. " + total);
}

// Clear cart after placing order
public void clearCart() {
    items.clear();
}
}
