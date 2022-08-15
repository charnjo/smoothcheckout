package com.smoothcheckout.service.impl;

import java.util.Map;

import com.smoothcheckout.model.Cart;
import com.smoothcheckout.model.CheckoutResult;
import com.smoothcheckout.model.Item;
import com.smoothcheckout.model.MultiPrice;
import com.smoothcheckout.service.CheckoutService;
import com.smoothcheckout.service.SuperMarketService;

public class CheckoutServiceImpl implements CheckoutService {

	SuperMarketService superMarketService;

	public CheckoutServiceImpl() {
		superMarketService = new SuperMarketServiceImpl();
	}

	@Override
	public CheckoutResult checkout(Cart cart) {

		CheckoutResult checkoutResult = new CheckoutResult();
		Double amountToPay = 0.0;

		//Loop through selected items
		for (Map.Entry<String, Integer> entry : cart.getMappedItems().entrySet()) {

			Double itemCost = 0.0;
			Item item = this.superMarketService.allItems().stream().filter(i -> i.getSku().equals(entry.getKey()))
					.findFirst().get();

			String itemId = entry.getKey();
			if (superMarketService.allMultiprices().stream().anyMatch(mp -> mp.getItemId().equals(itemId))) {
				MultiPrice itemMultiprice = this.superMarketService.allMultiprices().stream()
						.filter(mp -> mp.getItemId().equals(entry.getKey())).findFirst().get();
				int itemMultipriceQuantity = itemMultiprice.getQuantity();
				Double itemMultipriceValue = itemMultiprice.getPrice();

				int itemQuantyDiscounted = entry.getValue() - (entry.getValue() % itemMultipriceQuantity);

				itemCost = ((itemQuantyDiscounted * itemMultipriceValue / itemMultipriceQuantity)
						+ (entry.getValue() % itemMultipriceQuantity) * item.getPrice());
			} else {
				itemCost = entry.getValue() * item.getPrice();
			}

			amountToPay += itemCost;

		}

		checkoutResult.setFinalAmount(amountToPay);

		return checkoutResult;
	}


}