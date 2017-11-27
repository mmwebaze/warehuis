package warehuis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehuis.models.StoreItem;
import warehuis.repository.StoreItemRepository;

@Service
public class StoreItemServiceImp implements StoreItemService{

	@Autowired
	StoreItemRepository storeItemRepository;
	@Override
	public void save(StoreItem storeItem) {
		this.storeItemRepository.save(storeItem);		
	}

}
