package com.smoothcheckout.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.service.impl.CartServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CartServiceTest {

	CartService cartService = new CartServiceImpl();
	List<Cart> cartList = new ArrayList<>();
	Map<String, Integer> addedItems = new HashMap<String, Integer>();
	Cart defaultCart = new Cart("defaultCart");

	@BeforeAll
	void setup() {
		cartService = new CartServiceImpl();
		cartService.createCart("cart1");
		cartService.createCart("cart2");
		cartService.createCart("cart3");
		cartService.createCart(this.defaultCart.getCartId());

		cartList = cartService.getCartList();

		// Selected cart to use for testing
		Cart cart1 = cartService.returnCart("cart1");
		addedItems.put("A", 8);
		cart1.setMappedItems(addedItems);

	}

	@AfterAll
	void tearDown() {
		this.cartList.clear();
	}

	@Test
	void testCreateCart() {
		System.out.println(cartList.size());
		assertTrue(cartList.stream().count() > 0, () -> "Should have atleast 1 cart");
	}

	@Test
	void testClearCart() {
		
		cartService.addItem(this.defaultCart, "D");
		cartService.clearCart(this.defaultCart);
		assertTrue(this.defaultCart.getMappedItems().size() == 0);
		 
	}

	@Test
	void testReturnCart() {
		Cart cart = this.cartService.returnCart("cart1");
		assertTrue(cart.getCartId().equals("cart1"));
	}

	@Test
	void testAddItem() {
		cartService.addItem(this.defaultCart, "D");
		assertTrue(this.defaultCart.getMappedItems().size() > 0);
	}

	@Test
	void testRemoveItem() throws Exception {
		cartService.addItem(this.defaultCart, "D");
		cartService.removeItem(this.defaultCart, "D");
		assertTrue(this.defaultCart.getMappedItems().size() == 0);

	}

}
