package com.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.springapp.service.ProductManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class InventoryController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private ProductManager productManager;
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String now = (new Date()).toString();
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());
        return new ModelAndView("hello", "model", myModel);
    }

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

}
