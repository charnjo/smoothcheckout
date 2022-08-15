package com.smoothcheckout.service;

import java.util.ArrayList;
import java.util.List;

import com.smoothcheckout.model.Cart;

/**
 * @author charl
 *
 */
public interface CartService {
	
	List<Cart> carts = new ArrayList<>();
	
	/**
	 * @return cart list
	 */
	List<Cart>getCartList();
	
	/**
	 * @param cartId
	 */
	void createCart(String cartId);
	
	
	/*
	 * Removes all items from cart
	 */
	void clearCart(Cart cart);
	
	/*
	 * Returns cart
	 */
	Cart returnCart(String id);
	
	/**
	 * @param cart - where item is added
	 * @param id -id of item to add
	 */
	void addItem(Cart cart, String id);
	
	
	/**
	 * @param cart
	 * @param itemId
	 * @throws Exception 
	 */
	void removeItem(Cart cart, String itemId) throws Exception;
	
	static List<Cart> allCarts() {
		return carts;
	}
	

}
