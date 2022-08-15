package com.smoothcheckout;

import java.util.Scanner;

import com.smoothcheckout.service.impl.CheckoutClient;


public class SmoothCheckOutApplication {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		CheckoutClient client = new CheckoutClient(scanner);
		client.perFormCheckout();
		scanner.close();

	}

}
