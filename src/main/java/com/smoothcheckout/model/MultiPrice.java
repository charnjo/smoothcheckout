package com.smoothcheckout.model;

public class MultiPrice {
	private String itemId;
	private int quantity;
	private Double price;
	
	
	/**
	 * @param itemId
	 * @param quantity
	 * @param price
	 */
	public MultiPrice(String itemId, int quantity, Double price) {
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

}
