package com.smoothcheckout.service;

import java.util.List;

import com.smoothcheckout.model.Item;
import com.smoothcheckout.model.MultiPrice;

public interface SuperMarketService {
	
	List<Item> allItems();
	List<MultiPrice> allMultiprices();

}
