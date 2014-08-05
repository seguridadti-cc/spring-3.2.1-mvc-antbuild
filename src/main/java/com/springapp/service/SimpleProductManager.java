package com.springapp.service;

import com.springapp.domain.*;
import com.springapp.repository.*;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleProductManager implements ProductManager {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private ProductDao productDAO;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public List<Product> getProducts() {
		return this.products;        
    }
	
	public void reloadProducts() {
        this.products = productDAO.getProductList();
    }

    public void increasePrice(int percentage) {
    	if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                this.productDAO.saveProduct(product);
            }
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;        
    }

	public ProductDao getProductDAO() {
		return this.productDAO;
	}

	public void setProductDAO(ProductDao productDAO) {
		this.productDAO = productDAO;
	}

}
