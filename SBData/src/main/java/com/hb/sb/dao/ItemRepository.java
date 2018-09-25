package com.hb.sb.dao;

import java.util.List;
import com.hb.sb.dao.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}