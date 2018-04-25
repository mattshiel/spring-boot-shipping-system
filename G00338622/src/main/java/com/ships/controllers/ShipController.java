package com.ships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;


@Controller
public class ShipController {

	@Autowired
	ShipService shipService;
	
	// Request mapping maps web request to the controller method
	@RequestMapping(value = "/showShip", method=RequestMethod.GET)
	public String listShips(Model model) {
		
		// Get all ships
		List<Ship> ship = shipService.findAll();
		
		// Add the attribute
		model.addAttribute("ship", ship);
			
		// Return the page
		return "showShipping";
	}
} 