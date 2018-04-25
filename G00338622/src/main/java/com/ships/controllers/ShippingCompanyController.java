package com.ships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	// Request mapping maps web request to the controller method
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String listShippingCompany(Model model) {
		
		// Get all shipping companies
		List<ShippingCompany> shippingCompanies = shippingCompanyService.findAll();
		
		// Add the attribute
		model.addAttribute("shippingCompanies", shippingCompanies);
			
		// Return the page
		return "showShippingCompanies";
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addShippingCompanyGET(Model model) {

		// Create a new shipping company object
		ShippingCompany shippingCompany = new ShippingCompany();
		
		// Add the attribute
	 	model.addAttribute("shippingCompany", shippingCompany);			
			
	 	// Return the add shipping company page
	 	return "addShippingCompany";
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String addShippingCompanyPOST(@Valid @ModelAttribute("shippingCompany") ShippingCompany shippingCompany, BindingResult result, Model model) {
		
		// If an error is detected load the page again
		if (result.hasErrors()) {			
			return "addShippingCompany";
		}
		
		shippingCompanyService.save(shippingCompany);
		
		return "redirect:showShippingCompanies";
	}
}