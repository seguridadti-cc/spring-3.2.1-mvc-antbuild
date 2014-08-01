package com.springapp.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.*;

import junit.framework.TestCase;

public class PriceIncreaseValidatorTests extends TestCase {
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void testSetGetMinPerc() {
		PriceIncreaseValidator piv = new PriceIncreaseValidator();
		int min = 25;
		piv.setMinPercentage(min);
		assertEquals(min, piv.getMinPercentage());
	}
	
	public void testSetGetMaxPerc() {
		PriceIncreaseValidator piv = new PriceIncreaseValidator();
		int max = 25;
		piv.setMaxPercentage(max);
		assertEquals(max, piv.getMaxPercentage());
	}
	
	public void testValidate() {
		PriceIncreaseValidator validatorUnderTest = new PriceIncreaseValidator();
		PriceIncrease pi = new PriceIncrease();
		pi.setPercentage(10);
		Errors errors = new BeanPropertyBindingResult(pi, "PriceIncrease");
		validatorUnderTest.validate(pi, errors);
		assertFalse(errors.hasErrors());
	}
}
