package com.springapp.service;

import com.springapp.domain.*;
import com.springapp.repository.*;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleProductManager implements ProductManager {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ProductDao productDAO;
	
	public List<Product> getProducts() {
		return productDAO.getProductList();        
    }

	public void increasePrice(int percentage) {
		List<Product> products = productDAO.getProductList();
		for (Product product : products) {
			double newPrice = product.getPrice().doubleValue() * 
					(100 + percentage)/100;
			product.setPrice(newPrice);
			this.productDAO.updateProduct(product);
		}
	}

	public ProductDao getProductDAO() {
		return this.productDAO;
	}

	public void setProductDAO(ProductDao productDAO) {
		this.productDAO = productDAO;
	}

}
