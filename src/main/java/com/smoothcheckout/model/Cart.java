package com.smoothcheckout.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<String, Integer> mappedItems = new HashMap<String, Integer>();
	private String cartId;


	/**
	 * @param cartId
	 */
	public Cart(String cartId) {
		super();
		this.cartId = cartId;
	}

	public Map<String, Integer> getMappedItems() {
		return mappedItems;
	}

	public void setMappedItems(Map<String, Integer> mappedItems) {
		this.mappedItems = mappedItems;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}


	public boolean isEmpty() {
		return mappedItems.isEmpty();
	}
	
	@Override
	public String toString() {
		return "Cart [items=" + mappedItems + "]";
	}
}
