package warehuis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import warehuis.models.Item;
import warehuis.services.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="/api/items", method=RequestMethod.GET)
	public List<Item> getAllItems(){
		List<Item> items = this.itemService.getAllItems(0, 0);
		System.out.println(items.size()+" ******* ");
		return items;
	}
}
