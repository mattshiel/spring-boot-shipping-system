package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;

// Service holds business logic and calls the method in the repository layer.
@Service
public class ShippingCompanyService {
	@Autowired
	ShippingCompanyRepository shippingCompanyRepository;
	
	// Show all shipping companies method
	public List<ShippingCompany> findAll() {
		return (List<ShippingCompany>) shippingCompanyRepository.findAll();
	}
	
	// Save method for the shipping company
	public ShippingCompany save(ShippingCompany shippingCompany) {
		return shippingCompanyRepository.save(shippingCompany);	
	}
}