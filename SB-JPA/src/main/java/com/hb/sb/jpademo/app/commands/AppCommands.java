package com.hb.sb.shell.app.commands;

import com.hb.sb.jpademo.app.services.CustomerManagementService;
import com.hb.sb.jpademo.app.dao.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Component
@ShellComponent
public class AppCommands {
	
	@Autowired
	private CustomerManagementService customerManagementService;
	
	@ShellMethod(value = "Create a new customer", 
		key = "create-cust")
	public String createCustomer(String name) {
		boolean success = false;
		try {
			Customer customer = new Customer();
			customer.setName(name);
			success = customerManagementService.createCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		String message = "Failed to create user";
		if (success) {
			message = "Created successfully";
		}
		return message;
	}
	
	@ShellMethod(value = "List customers", 
		key = "find-cust-byID")
	public String findCustomer(long id) {
		Customer cust = customerManagementService.findCustomer(id);
		return cust.toString();
	}
}

