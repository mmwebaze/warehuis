package warehuis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import warehuis.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
	@Query("select I from Item I")
	List<Item> findAll();
}
