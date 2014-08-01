package com.springapp.service;

import static org.junit.Assert.*;
import junit.framework.TestCase;

public class PriceIncreaseTests extends TestCase {

	public void testSetGetPercentage() {
		PriceIncrease pi = new PriceIncrease();
		int perc = 10;
		pi.setPercentage(perc);
		assertEquals(perc, pi.getPercentage());
	}

}
