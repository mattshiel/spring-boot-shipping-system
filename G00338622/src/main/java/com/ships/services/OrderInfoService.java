package com.ships.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInfoRepository;
import com.ships.repositories.ShipRepository;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class OrderInfoService {
	@Autowired
	OrderInfoRepository orderInfoRepository;
	@Autowired
	ShipRepository shipRepository;
	@Autowired
	ShippingCompanyRepository shipCompanyRepository;
	
	Ship ship;
	ShippingCompany shippingCompany;
	
	
	public List<OrderInfo> findAll() {
		return (List<OrderInfo>) orderInfoRepository.findAll();
	}
	
	public OrderInfo save(OrderInfo orderInfo) {
		
		setCurrentDate(orderInfo);																			
		
		ship = shipRepository.findOne(orderInfo.getShip().getSid());									
		shippingCompany = shipCompanyRepository.findOne(orderInfo.getShippingCompany().getScid());			
		
		ship.setShippingCompany(shippingCompany);												
		return orderInfoRepository.save(orderInfo);		
	}
	
	private void setCurrentDate(OrderInfo orderInfo){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate now = LocalDate.now();;
		orderInfo.setDate(dateFormat.format(now));
	}
}