package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	@Autowired
	ShipRepository shipRepository;

	// Finds all ships
	public List<Ship> findAll() {
		return (List<Ship>) shipRepository.findAll();
	}
	
	// Saves a ship to the repository
	public Ship save(Ship ship) {		
		return shipRepository.save(ship);		
	}
}