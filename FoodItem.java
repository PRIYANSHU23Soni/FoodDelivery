package com.tns.fooddeliverysystem.entities;

public class FoodItem {
	private int id;
	private String name;
	private double price;
	
	
	public FoodItem(int id,String name,double price) {
		this.id=id;
		this.name=name;
		this.price=price;
		
		
	}
	
	public void setid(int id) {
		this.id=id;
	}
	public int getid() {
		return this.id;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String gettname() {
		return this.name;
		
	}
	public void setprice(double price) {
		this.price=price;
		
	}
	public double getprice() {
		return this.price;
	}
	@Override
    public String toString() {
        return "FoodItem{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
	
	
}
