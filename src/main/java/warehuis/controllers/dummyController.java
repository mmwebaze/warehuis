package warehuis.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehuis.models.Carousel;
import warehuis.models.Item;
import warehuis.models.Store;
import warehuis.models.StoreItem;
import warehuis.repository.CarouselRepository;
import warehuis.repository.ItemRepository;
import warehuis.repository.StoreItemRepository;
import warehuis.repository.StoreRepository;
import warehuis.services.CarouselService;
import warehuis.services.ItemService;
import warehuis.services.StoreItemService;
import warehuis.services.StoreService;

@RestController
public class dummyController {
	@Autowired
	private CarouselService carouselService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private ItemService itemService;
	@Autowired
	StoreItemService storeItemService;
	@RequestMapping("/data")
	public String generateDummyData() {
		
		// create dummy carousel
		Carousel carousel = new Carousel();
		carousel.setDescription("My lovely carousel");
		carousel.setImageUrl("/images/carousel_1.jpg");
		carousel.setName("My carousel");
		this.carouselService.save(carousel);
		
		// create dummy items
		Item pineapple = new Item("PINE_LUWERO","pineapples","pineapples from luwero","/images/pineapples.jpg");
		Item savedPineapple = itemService.save(pineapple);
				
		Item banana = new Item("BANAN_MUSHANGA","Bananas","Bananas from mushanga sheema","/images/banana.jpg");
		Item savedBanana = itemService.save(banana);
				
		Item apple = new Item("APPLES_KBLE", "Apples", "Green apples from Kabale", "/images/apples.jpg");
		Item savedApple = itemService.save(apple);

		Calendar currenttime = Calendar.getInstance();
		Date createdDate = new Date((currenttime.getTime()).getTime());
		
		// create dummy stores without inventory
		Store store1 = new Store("BUGOS1", "michael.mwebaze@gmail.com", true, createdDate);
		Store savedStoreOne = this.storeService.save(store1);
		
		Store store2 = new Store("BUGOS2", "mwebaze@outlook.com", false, createdDate);
		Store savedStoreTwo = this.storeService.save(store2);
		
		// Creating store inventories
		StoreItem inventoryStoreOneBanana = new StoreItem();
		inventoryStoreOneBanana.setStore(savedStoreOne);
		inventoryStoreOneBanana.setItem(savedBanana);
		inventoryStoreOneBanana.setPrice(3500);
		inventoryStoreOneBanana.setNumberItems(100);
		
		StoreItem inventoryStoreOnePineapple = new StoreItem();
		inventoryStoreOnePineapple.setIdStoreItem(2);
		inventoryStoreOnePineapple.setStore(savedStoreOne);
		inventoryStoreOnePineapple.setItem(savedPineapple);
		inventoryStoreOnePineapple.setPrice(1950);
		inventoryStoreOnePineapple.setNumberItems(50);
		
		StoreItem inventoryStoreOneApple = new StoreItem();
		inventoryStoreOneApple.setIdStoreItem(3);
		inventoryStoreOneApple.setStore(savedStoreTwo);
		inventoryStoreOneApple.setItem(savedApple);
		inventoryStoreOneApple.setPrice(2500);
		inventoryStoreOneApple.setNumberItems(1000);
	
		try {
			this.storeItemService.save(inventoryStoreOnePineapple);
			this.storeItemService.save(inventoryStoreOneBanana);
			this.storeItemService.save(inventoryStoreOneApple);
		} catch (Exception e) {
			System.out.println("************->"+e.getLocalizedMessage());
		}
		
		System.out.println("##################");
		
		return "dummy data generated";
	}
}
