package com.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.springapp.service.PriceIncreaseValidator;
import com.springapp.service.ProductManager;
import com.springapp.service.PriceIncrease;

@Controller
@RequestMapping("/priceIncrease.do")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private PriceIncreaseValidator priceIncreaseValidator;
    
    @Autowired
    private ProductManager productManager;

    
    @RequestMapping(method=RequestMethod.POST)
    public String onSubmit(
    		@ModelAttribute("priceIncrease") PriceIncrease priceIncrease, 
    		BindingResult result)
            throws ServletException {
        
        priceIncreaseValidator.validate(priceIncrease, result);
        if (result.hasErrors()) {
        	return "priceIncrease";  
        }
        else {
        	int increase = priceIncrease.getPercentage();
        	logger.info("Increasing prices by " + increase + "%.");
	
	        productManager.increasePrice(increase);
	
	        return "redirect:products.do";
        }
    }

    @RequestMapping(method=RequestMethod.GET) 
    public String initializeForm(ModelMap model) { 
        // Perform and Model / Form initialization
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);  
        model.addAttribute("priceIncrease", priceIncrease);   
        return "priceincrease"; 
    } 

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

	public PriceIncreaseValidator getPriceIncreaseValidator() {
		return priceIncreaseValidator;
	}

	public void setPriceIncreaseValidator(
			PriceIncreaseValidator priceIncreaseValidator) {
		this.priceIncreaseValidator = priceIncreaseValidator;
	}

}