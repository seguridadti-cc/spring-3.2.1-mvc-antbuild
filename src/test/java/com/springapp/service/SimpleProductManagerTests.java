package com.springapp.service;

import com.springapp.domain.*;
import com.springapp.repository.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import junit.framework.TestCase;
import com.springapp.repository.*;


public class SimpleProductManagerTests extends TestCase {
	
    private SimpleProductManager productManager;
    protected final Log logger = LogFactory.getLog(getClass());
   
   
    private static int POSITIVE_PRICE_INCREASE = 10;
    private ApplicationContext testContext;
    protected void setUp() {
    	testContext = new FileSystemXmlApplicationContext("classpath:test-context.xml");
    }
    
    public void testGetProducts() {
    	productManager = (SimpleProductManager)testContext.getBean("productManager");
        assertNotNull(productManager.getProducts());
    }

    public void testIncreasePriceWithPositivePercentage() {
    	productManager = (SimpleProductManager)testContext.getBean("productManager");
    	assertNotNull("JdbcProductDao: null", productManager.getProductDAO()); 	
    	List<Product> products = productManager.getProducts(); 
    	Product first = products.get(0);
    	productManager.increasePrice(POSITIVE_PRICE_INCREASE);
    	products = productManager.getProducts(); 
    	first = products.get(0);
    	Double actualValue = first.getPrice(); 
    	Double expectedValue = (actualValue.doubleValue() * ((100 + POSITIVE_PRICE_INCREASE)/100));
        assertEquals(expectedValue, actualValue);     
    }
    
}
