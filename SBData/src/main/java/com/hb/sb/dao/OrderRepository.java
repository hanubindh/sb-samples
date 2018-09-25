package com.hb.sb.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.hb.sb.dao.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}