package com.smoothcheckout.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.model.CheckoutResult;
import com.smoothcheckout.service.impl.CartServiceImpl;
import com.smoothcheckout.service.impl.CheckoutServiceImpl;
import com.smoothcheckout.service.impl.SuperMarketServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CheckoutServiceTest {
	
	CartService cartService = new CartServiceImpl();
	List<Cart> cartList = new ArrayList<>();
	Map<String, Integer> addedItems = new HashMap<String, Integer>();
	Map<String, Integer> addedItems2 = new HashMap<String, Integer>();
	Map<String, Integer> addedItems3 = new HashMap<String, Integer>();

	Cart defaultCart = new Cart("defaultCart");
	Cart defaultCart2 = new Cart("defaultCart2");
	Cart defaultCart3 = new Cart("defaultCart3");
	
	CheckoutResult checkoutResult;
	SuperMarketService superMarkerService;
	CheckoutService checkoutService;

	@BeforeAll
	void setup() {
		cartService = new CartServiceImpl();
		cartService.createCart(this.defaultCart.getCartId());
		cartService.createCart(this.defaultCart2.getCartId());
		cartService.createCart(this.defaultCart3.getCartId());

		cartList = cartService.getCartList();

		addedItems.put("A", 8);
		defaultCart.setMappedItems(addedItems);
		
		addedItems2.putAll(addedItems);
		addedItems2.put("B", 1);	
		defaultCart2.setMappedItems(addedItems2);
		
		addedItems3.putAll(addedItems2);
		addedItems3.put("C", 2);
		defaultCart3.setMappedItems(addedItems3);
		
		checkoutResult = new CheckoutResult();
		checkoutService = new CheckoutServiceImpl();
		superMarkerService = new SuperMarketServiceImpl();
		
	}
	
	@AfterAll
	void tearDown() {
		this.addedItems.clear();
	}
	
	@Test
	@DisplayName("Checkout tests")
	void testCheckout() {
		Assertions.assertAll(
		       () -> assertEquals(checkoutService.checkout(defaultCart).getFinalAmount(), 3.6),
		       () -> assertEquals(checkoutService.checkout(defaultCart2).getFinalAmount(), 3.9),
		       () -> assertEquals(checkoutService.checkout(defaultCart3).getFinalAmount(), 4.3));
	}

}
