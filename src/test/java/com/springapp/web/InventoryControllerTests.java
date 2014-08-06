package com.springapp.web;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.domain.Product;
import com.springapp.service.ProductManager;
import com.springapp.service.SimpleProductManager;
import com.springapp.web.InventoryController;

import junit.framework.TestCase;

public class InventoryControllerTests extends TestCase {
	private SimpleProductManager productManager;
    private ApplicationContext testContext;
    
    protected void setUp() {
    	testContext = new FileSystemXmlApplicationContext("classpath:test-context.xml");
    }
	
    public void testHandleRequestView() throws Exception{		
    	productManager = (SimpleProductManager)testContext.getBean("productManager");
    	InventoryController controller = new InventoryController();
        controller.setProductManager(productManager);
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("products", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}