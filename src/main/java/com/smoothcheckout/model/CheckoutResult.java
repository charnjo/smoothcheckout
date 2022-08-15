package com.smoothcheckout.model;

public class CheckoutResult {
	private Cart cart;
	private Integer finalAmount;
	
	public CheckoutResult() {}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Integer finalAmount) {
		this.finalAmount = finalAmount;
	}

}
