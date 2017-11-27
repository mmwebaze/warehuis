package warehuis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehuis.models.Store;
import warehuis.repository.StoreRepository;

@Service
public class StoreServiceImp implements StoreService{
	@Autowired
	private StoreRepository storeRepository;
	@Override
	public List<Store> getAllStores(Integer page, Integer size) {
		List<Store> stores = this.storeRepository.findAll();
		return stores;
	}
	public Store save(Store store) {
		
		return this.storeRepository.save(store);
	}
}
