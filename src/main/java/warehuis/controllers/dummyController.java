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

@RestController
public class dummyController {
	@Autowired
	private CarouselRepository carouselRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	StoreItemRepository storeItemRepository;
	@RequestMapping("/data")
	public String generateDummyData() {
		
		// create dummy carousel
		Carousel carousel = new Carousel();
		carousel.setDescription("My lovely carousel");
		carousel.setImageUrl("/images/carousel_1.jpg");
		carousel.setName("My carousel");
		this.carouselRepository.save(carousel);
		
		// create dummy items
		Item pineapple = new Item("PINE_LUWERO","pineapples","pineapples from luwero","/images/pineapples.jpg");
		Item savedPineapple = itemRepository.save(pineapple);
				
		Item banana = new Item("BANAN_MUSHANGA","Bananas","Bananas from mushanga sheema","/images/banana.jpg");
		Item savedBanana = itemRepository.save(banana);
				
		Item apple = new Item("APPLES_KBLE", "Apples", "Green apples from Kabale", "/images/apples.jpg");
		Item savedApple = itemRepository.save(apple);

		Calendar currenttime = Calendar.getInstance();
		Date createdDate = new Date((currenttime.getTime()).getTime());
		
		//default inventory
		
		// create dummy stores without inventory
		Store store1 = new Store("BUGOS1", "michael.mwebaze@gmail.com", true, createdDate);
		Store savedStoreOne = this.storeRepository.save(store1);
		
		Store store2 = new Store("BUGOS2", "mwebaze@outlook.com", false, createdDate);
		Store savedStoreTwo = this.storeRepository.save(store2);
		
		StoreItem defaultStoreItem = new StoreItem();
		defaultStoreItem.setStore(savedStoreOne);
		defaultStoreItem.setItem(savedBanana);
		defaultStoreItem.setPrice(3500);
		defaultStoreItem.setNumberItems(100);
		//store1.getStoreItem().add(defaultStoreItem);
		
		
		

		//Create Store one inventory
		StoreItem inventoryStoreOne = new StoreItem();
		//inventoryStoreOne.setStore(store1);
		inventoryStoreOne.setIdStoreItem(2);
		inventoryStoreOne.setStore(savedStoreOne);
		inventoryStoreOne.setItem(savedPineapple);
		inventoryStoreOne.setPrice(1950);
		inventoryStoreOne.setNumberItems(50);
	
		//savedStoreOne.setStoreItem(s);
		
		/*Set<StoreItem> s = new HashSet<StoreItem>();
		s.add(inventoryStoreOne);
		savedStoreOne.setStoreItem(s);*/
		//System.out.println(savedStoreOne.getStoreItem());
		//store1.getStoreItem().add(inventoryStoreOne);
		//savedStoreOne.getStoreItem().get(0).setSalePrice(400000);
		/*Iterator<StoreItem> it = saved.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getStore().getId());  
		}*/
		
		try {
			this.storeItemRepository.save(inventoryStoreOne);
			System.out.println("Now inserting the second one");
			this.storeItemRepository.save(defaultStoreItem);
		} catch (Exception e) {
			System.out.println("************->"+e.getLocalizedMessage());
		}
		
		System.out.println("##################");
		
		/*StoreItem inventoryStoreTwo = new StoreItem();
		inventoryStoreTwo.setStore(savedStoreOne);
		inventoryStoreTwo.setItem(savedPineapple);
		inventoryStoreTwo.setPrice(3500);
		inventoryStoreTwo.setNumberItems(40);
		savedStoreOne.getStoreItem().add(inventoryStoreTwo);
		storeRepository.save(savedStoreOne);
		
		//Create Store two inventory
		StoreItem inventoryStore1 = new StoreItem();
		inventoryStore1.setStore(savedStoreTwo);
		inventoryStore1.setItem(savedBanana);
		inventoryStore1.setPrice(2000);
		savedStoreTwo.getStoreItem().add(inventoryStore1);
		System.out.println(inventoryStore1.getStore().getCode());
		storeRepository.save(savedStoreTwo);
		
		StoreItem inventoryStore2 = new StoreItem();
		inventoryStore2.setStore(savedStoreTwo);
		inventoryStore2.setItem(savedPineapple);
		inventoryStore2.setPrice(5000);
		inventoryStore2.setNumberItems(100);
		savedStoreTwo.getStoreItem().add(inventoryStore2);
		storeRepository.save(savedStoreTwo);*/
		
		return "dummy data generated";
	}
}
