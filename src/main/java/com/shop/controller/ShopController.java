package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model2.Address;
import com.shop.model.Employee;
import com.shop.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	ShopService shopService;
	

	@GetMapping("/allEmployee")
	public ResponseEntity<List<Employee>> getEmployee() {
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(shopService.empList(),
				HttpStatus.FOUND);
		return response;

	}

	@GetMapping("/allAddress")
	public ResponseEntity<List<Address>> getAddress() {
		ResponseEntity<List<Address>> response = new ResponseEntity<List<Address>>(shopService.addressList(),
				HttpStatus.FOUND);
		return response;

	}

	@PostMapping("/saveEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return shopService.addEmployee(emp);
	}

	@PostMapping("/saveAddress")
	public Address addAddress(@RequestBody Address address) {
		return shopService.addAddress(address);
	}

}
