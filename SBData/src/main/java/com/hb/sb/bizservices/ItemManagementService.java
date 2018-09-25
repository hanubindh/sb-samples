package com.hb.sb.bizservices;

import com.hb.sb.dao.ItemRepository;
import com.hb.sb.dao.entities.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemManagementService {

	@Autowired
	private ItemRepository repo;

	public boolean createItem(Item item) {
		repo.save(item);
		return true;
	}
	
	public Item findItem(long id) {
		return repo.findById(id).get();
	}
	
	public Iterable<Item> findAll() {
		return repo.findAll();
	}		
}