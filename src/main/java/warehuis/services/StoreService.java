package warehuis.services;

import java.util.List;

import warehuis.models.Store;

public interface StoreService {
	List<Store> getAllStores(Integer page, Integer size);
}
