package warehuis.repository;

import org.springframework.data.repository.CrudRepository;

import warehuis.models.Item;
import warehuis.models.StoreItem;

public interface StoreItemRepository extends CrudRepository<StoreItem, Long>{
	
}
