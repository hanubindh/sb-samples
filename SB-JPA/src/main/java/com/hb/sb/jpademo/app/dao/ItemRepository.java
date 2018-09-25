package com.hb.sb.jpademo.app.dao;

import java.util.List;
import com.hb.sb.jpademo.app.dao.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}