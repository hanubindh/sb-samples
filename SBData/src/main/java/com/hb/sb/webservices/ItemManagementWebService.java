package com.hb.sb.webservices;

import com.hb.sb.bizservices.ItemManagementService;
import com.hb.sb.dao.entities.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/item")
public class ItemManagementWebService {

	@Autowired
	private ItemManagementService itemManagementService;
	
	@PutMapping("/create")
	public boolean createItem(@RequestBody Item item) {
		return itemManagementService.createItem(item);
	}
	
	@GetMapping("/{id}")
	public Item findItem(@PathVariable long id) {
		return itemManagementService.findItem(id);
	}
	
	@GetMapping("/all")
	public Iterable<Item> findAll() {
		return itemManagementService.findAll();
	}		
}