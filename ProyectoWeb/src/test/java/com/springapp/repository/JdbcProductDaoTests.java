package com.springapp.repository;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.springapp.domain.Product;

@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class JdbcProductDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
	
	private ProductDao productDao;
	    
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @BeforeTransaction
    public void setUpData() throws Exception {
        deleteFromTables("products");
        executeSqlScript("file:db/load_data.sql", true);
    }

    @Test
    public void testGetProductList() {
        
        List<Product> products = productDao.getProductList();
        
        assertEquals("wrong number of products?", 3, products.size());
    }
    
    @Test
    public void testSaveProduct() {
        
        List<Product> products = productDao.getProductList();
        
        for (Product p : products) {
            p.setPrice(200.12);
            productDao.updateProduct(p);
        }
        
        List<Product> updatedProducts = productDao.getProductList();
        for (Product p : updatedProducts) {
            assertEquals("wrong price of product?", 200.12, p.getPrice(), 0.001);
        }
    }
}
