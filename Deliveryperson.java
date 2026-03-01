package com.tns.fooddeliverysystem.entities;

public class Deliveryperson {
	private int deliveryPersonId;
	private String name;
	private long contactNo;
	
	public Deliveryperson(int deliveryPersonId,String name ,long contactNo) {
		this.deliveryPersonId=deliveryPersonId;
		this.name=name;
		this.contactNo=contactNo;
	}
	public int getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getName() {
        return name;
    }

    public long getContactNo() {
        return contactNo;
    }
    @Override
    public String toString() {
        return "DeliveryPerson ID: " + deliveryPersonId + 
               ", Name: " + name;
    }
}
