package com.springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springapp.domain.Product;

public class JdbcProductDao implements ProductDao {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private JdbcTemplate jdbcTemplate;
    
    public List<Product> getProductList() {       
        List<Product> products = new ArrayList<Product>();
    	JdbcTemplate template = getJdbcTemplate();
    	products = template.query("select id, description, price from products", 
                					new ProductMapper());  
        return products;
    }
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void updateProduct(Product prod) {
        logger.info("updating:" + prod);
        getJdbcTemplate().update(
        		"update products set description = ?, price = ? where id = ?",
        		new Object[] { prod.getDescription(), prod.getPrice(), prod.getId() });
    }
    
    private static class ProductMapper implements RowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(Double.valueOf(rs.getDouble("price")));
            return prod;
        }

    }
}