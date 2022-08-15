package com.smoothcheckout.model;

public class CheckoutResult {
	private Cart cart;
	private Double finalAmount;
	
	public CheckoutResult() {}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
