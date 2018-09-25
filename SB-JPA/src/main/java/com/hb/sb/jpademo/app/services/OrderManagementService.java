package com.hb.sb.jpademo.app.services;

import com.hb.sb.jpademo.app.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderManagementService {

	@Autowired
	private OrderRepository repo;

}
