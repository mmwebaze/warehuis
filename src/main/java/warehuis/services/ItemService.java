package warehuis.services;

import java.util.List;

import warehuis.models.Item;

public interface ItemService {
	List<Item> getAllItems(Integer page, Integer size);
	public Item save(Item item);
}
