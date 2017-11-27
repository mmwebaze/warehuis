package warehuis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehuis.models.Item;
import warehuis.repository.ItemRepository;

@Service
public class ItemServiceImp implements ItemService{
	@Autowired
	private ItemRepository itemRepository;
	@Override
	public List<Item> getAllItems(Integer page, Integer size) {
		
		return this.itemRepository.findAll();
	}
	@Override
	public Item save(Item item) {
		return this.itemRepository.save(item);
	}

}
