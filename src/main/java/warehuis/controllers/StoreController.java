package warehuis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehuis.models.Store;
import warehuis.services.StoreService;

@RestController
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/api/stores")
	public List<Store> getAllStores(){
		
		return this.storeService.getAllStores(0,0);
	}
}
