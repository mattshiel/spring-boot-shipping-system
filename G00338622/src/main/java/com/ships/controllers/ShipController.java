package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShipController {

	@Autowired
	ShipService shipService;
	
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	// Request mapping maps web request to the controller method
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String listShips(Model model) {
		
		// Get all ships
		List<Ship> ships = shipService.findAll();
		
		// Add the attribute
		model.addAttribute("ships", ships);
			
		// Return the page
		return "showShips";
	}
	
	// Method for the addShip get request
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShipGET(Model model) {

		// Create a new ship object
		Ship ship = new Ship();
		
		// Add the attribute
 		model.addAttribute("ship", ship);
					
 		// Return the page
		return "addShip";
	}
	
	// Method for the addShip post request
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShipPOST(@ModelAttribute("ship") Ship ship, Model model) {
		
		// Save the ship
		shipService.save(ship);
		
		// Redirect and display the ships
		return "redirect:showShips";
 	}
} 