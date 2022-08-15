package com.smoothcheckout.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.smoothcheckout.model.Item;
import com.smoothcheckout.model.MultiPrice;
import com.smoothcheckout.service.SuperMarketService;

public class SuperMarketServiceImpl implements SuperMarketService {
	
	List<Item> allItems = new ArrayList<>();
	List<MultiPrice> allMultiPrices = new ArrayList<>();
	
	public SuperMarketServiceImpl() {
		
	}

	@Override
	public List<Item> allItems() {
		populateStoreItems();
		return allItems;
	}
	
	@Override
	public List<MultiPrice> allMultiprices() {
		this.populateStoreMultiPrice();
		return allMultiPrices;
	}
	
	public void populateStoreItems() {
		Item itemA = new Item("A", 0.50);
		allItems.add(itemA);
		
		Item itemB = new Item("B", 0.30);
		allItems.add(itemB);

		Item itemC = new Item("C", 0.20);
		allItems.add(itemC);

		Item itemD = new Item("D", 0.15);
		allItems.add(itemD);

	}

	public void populateStoreMultiPrice() {
		MultiPrice mp1 = new MultiPrice("A", 3, 1.30);
		allMultiPrices.add(mp1);
		
		MultiPrice mp2 = new MultiPrice("B", 2, 0.45);
		allMultiPrices.add(mp2);

	}

}
