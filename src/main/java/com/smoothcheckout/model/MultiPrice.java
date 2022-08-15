package com.smoothcheckout.model;

public class MultiPrice {
	private String itemId;
	private int quantity;
	private Integer price;
	
	
	/**
	 * @param itemId
	 * @param quantity
	 * @param price
	 */
	public MultiPrice(String itemId, int quantity, Integer price) {
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	

}
