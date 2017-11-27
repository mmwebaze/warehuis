package warehuis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import warehuis.models.Store;


public interface StoreRepository extends JpaRepository<Store, Long>{
	List<Store> findAll();
}
