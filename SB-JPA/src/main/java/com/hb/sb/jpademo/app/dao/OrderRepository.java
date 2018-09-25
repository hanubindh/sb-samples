package com.hb.sb.jpademo.app.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.hb.sb.jpademo.app.dao.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}