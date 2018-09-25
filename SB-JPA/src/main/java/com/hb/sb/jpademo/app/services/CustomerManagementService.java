package com.hb.sb.jpademo.app.services;

import com.hb.sb.jpademo.app.dao.CustomerRepository;
import com.hb.sb.jpademo.app.dao.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerManagementService {

	@Autowired
	private CustomerRepository repo;
	
	public boolean createCustomer(Customer customer) {
		repo.save(customer);
		return true;
	}
	
	public Customer findCustomer(long id) {
		return repo.findById(id).get();
	}	

}