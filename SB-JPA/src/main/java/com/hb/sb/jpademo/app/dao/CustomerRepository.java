package com.hb.sb.jpademo.app.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.hb.sb.jpademo.app.dao.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}