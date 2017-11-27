package warehuis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import warehuis.models.Carousel;
import warehuis.services.CarouselService;
import warehuis.services.CarouselServiceImp;

@RestController
public class CarouselController {
	@Autowired
	private CarouselService carouselService;
	@RequestMapping("/api/carousels")
	public @ResponseBody List<Carousel> carousel() {
		
		//return new Carousel();
		
		return this.carouselService.getAllCarousels(0, 0);
	}
}
