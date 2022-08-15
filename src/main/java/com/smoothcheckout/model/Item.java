package com.smoothcheckout.model;

public class Item {
	private String sku;
	private Double price;

	/**
	 * @param sku
	 * @param price
	 */
	public Item(String sku, Double price) {
		super();
		this.sku = sku;
		this.setPrice(price);
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}
