package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Employee;
import com.shop.model2.Address;
import com.shop.repo.EmployeeRepo;
import com.shop.repo2.AddressRepo;

@Service
public class ShopService {

	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	AddressRepo addressRepo;


	public List<Employee> empList() {

		List<Employee> empList = employeeRepo.findAll();
		return empList;
	}

	public List<Address> addressList() {

		List<Address> addList = addressRepo.findAll();
		return addList;
	}

	public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

}
