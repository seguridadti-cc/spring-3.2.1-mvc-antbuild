package com.springapp.repository;

import java.util.List;

import com.springapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void updateProduct(Product prod);

}
