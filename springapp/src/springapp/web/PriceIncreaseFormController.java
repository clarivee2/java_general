package springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.ProductManager;
import springapp.service.PriceIncrease;

// this deviates from the web example - need to use annotated controllers for 
//  forms
@Controller
public class PriceIncreaseFormController  {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private ProductManager productManager;

    @RequestMapping(value="/priceincrease.htm", method=RequestMethod.POST)
    public ModelAndView increasePriceSubmit(@ModelAttribute("PriceIncrease") PriceIncrease priceIncrease, BindingResult PriceIncrease)
            throws ServletException {

    	String failureView = "priceincrease.htm"; // TODO - make this dynamic - no slashes here
    	String successView = "inventory.htm"; 
    	
        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        if( PriceIncrease.hasErrors()) {
        	// validation errors found - redirect to same view
        	logger.info("Found validation errors: returning from PriceIncreaseForm view to " + failureView);
        	return new ModelAndView(new RedirectView(failureView));
        }
        else {
            logger.info("returning from PriceIncreaseForm view to " + successView);
            return new ModelAndView(new RedirectView(successView));
        }
    }

    // No longer needed in V3
//    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
 
    // in V3 just create your method
    @RequestMapping(value="/priceincrease.htm", method=RequestMethod.GET)
    public PriceIncrease increasePrice() {
    PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        return priceIncrease;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}