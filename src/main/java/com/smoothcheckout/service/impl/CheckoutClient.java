package com.smoothcheckout.service.impl;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.model.CheckoutResult;
import com.smoothcheckout.service.CartService;
import com.smoothcheckout.service.CheckoutService;




public class CheckoutClient {
	private Scanner scanner;
	private CartService cartService;
	private CheckoutService checkoutService;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	
	public CheckoutClient(Scanner scanner) {
		cartService = new CartServiceImpl();
		checkoutService = new CheckoutServiceImpl();
		this.scanner = scanner;
	}

	public void perFormCheckout() {
		String cartId = this.startScan();
		this.cartService.createCart(cartId);
		Cart cart = this.cartService.returnCart(cartId);
		
		String itemId = this.scanItem();		
		this.cartService.addItem(cart, itemId);
		
		itemId = this.scanMore(cart);
		while (!itemId.trim().equalsIgnoreCase("Done")) {
			this.cartService.addItem(cart, itemId);
		      itemId = scanMore(cart);	    
		}
		
		CheckoutResult checkoutResult = this.checkoutService.checkout(cart);
		this.completed(checkoutResult);
	}
	
	public String startScan() {
	    System.out.println("== Checkout application ==");
	    System.out.println("Enter cart name to start: ");
	    return scanner.nextLine();
	  
	}
	
	public String scanItem() {
	    System.out.println("Scan item(By entering sku): ");
	    return scanner.nextLine();
	}
	
	public String scanMore(Cart cart) {
	    System.out.println(cart.toString());
	    System.out.println("Scan more or type 'Done' to proceed to checkout)");
	    return scanner.nextLine();
	  
	}
	

	private void completed(CheckoutResult result) {
	
		
		//Return in pounds
		StringBuilder totalBuilder = new StringBuilder();
		totalBuilder.append("Total: ");
		
		if(result.getFinalAmount() >= 100) {
			totalBuilder.append("£" + df.format(result.getFinalAmount() / 100));
		}
		else {
			totalBuilder.append(result.getFinalAmount() + "p");
		}
			
		System.out.println(totalBuilder.toString());
		
	}
	

}
