/**
 * 
 */
package com.smoothcheckout.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.service.CartService;
import com.smoothcheckout.service.SuperMarketService;

/**
 * @author charl
 *
 */
public class CartServiceImpl extends Exception implements CartService {
	
	private static final long serialVersionUID = -9076435945528315325L;
	List<Cart> cartList = new ArrayList<>();
	SuperMarketService superMarketService;
	
	public CartServiceImpl() {
		superMarketService = new SuperMarketServiceImpl();
		
	}
	
	@Override
	public void createCart(String cartId) {
		Cart cart = new Cart(cartId);
		cartList.add(cart);
	}
	
	@Override
	public Cart returnCart(String id) {
		return cartList.stream().filter(c -> c.getCartId().equals(id)).findFirst().get();
	}

	@Override
	public void addItem(Cart cart, String id) {
		if(this.superMarketService.allItems().stream().filter(i -> i.getSku().equals(id)).count() < 1) {
			System.out.println("Item not in stock");
			return;
		}
		Map<String, Integer> itemsOnCart = cart.getMappedItems();
		if(itemsOnCart.containsKey(id)){
			itemsOnCart.put(id, itemsOnCart.get(id) + 1);
		} else {
			itemsOnCart.put(id, 1);
		}
	}

	@Override
	public void removeItem(Cart cart, String itemId) throws Exception {
		Map<String, Integer> itemsOnCart = cart.getMappedItems();
		if(itemsOnCart.containsKey(itemId)) {
			itemsOnCart.remove(itemId);
		}
		else {
			throw new Exception("Item not found");
		}
	}

	@Override
	public void clearCart(Cart cart) {
		Map<String, Integer> itemsOnCart = cart.getMappedItems();
		itemsOnCart.clear();
	}

	@Override
	public List<Cart> getCartList() {
		return this.cartList;
	}


}
