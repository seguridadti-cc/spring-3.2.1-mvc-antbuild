package com.springapp.domain;

import java.io.Serializable;

public class Product implements Serializable {
	
	private int id;
    private String description;
    private Double price;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Id: " + id + ";");
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }
}