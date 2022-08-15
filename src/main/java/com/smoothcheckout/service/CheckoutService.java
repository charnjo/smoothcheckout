package com.smoothcheckout.service;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.model.CheckoutResult;

public interface CheckoutService {
	
	CheckoutResult checkout(Cart cart);

}
