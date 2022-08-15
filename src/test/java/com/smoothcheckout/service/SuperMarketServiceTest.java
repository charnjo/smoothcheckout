package com.smoothcheckout.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.smoothcheckout.model.Item;
import com.smoothcheckout.model.MultiPrice;
import com.smoothcheckout.service.impl.SuperMarketServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SuperMarketServiceTest {
	SuperMarketService superMarketService = new SuperMarketServiceImpl();
	List<Item> allItems = new ArrayList<>();
	List<MultiPrice> allMultiPrices = new ArrayList<>();
	
	@BeforeAll
	void setUp() {
		Item itemA = new Item("A", 50);
		allItems.add(itemA);
		
		Item itemB = new Item("B", 30);
		allItems.add(itemB);

		Item itemC = new Item("C", 20);
		allItems.add(itemC);

		Item itemD = new Item("D", 15);
		allItems.add(itemD);
		
		MultiPrice mp1 = new MultiPrice("A", 3, 130);
		allMultiPrices.add(mp1);
		
		MultiPrice mp2 = new MultiPrice("B", 2, 45);
		allMultiPrices.add(mp2);
		
	}

	@Test
	void testAllItems() {
		assertTrue(this.superMarketService.allItems().size() > 0);
	}

	@Test
	void testAllMultiprices() {
		assertTrue(this.superMarketService.allMultiprices().size() > 0);
	}

}
