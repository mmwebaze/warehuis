package warehuis.services;

import java.util.List;

import warehuis.models.Carousel;


public interface CarouselService {
	List<Carousel> getAllCarousels(Integer page, Integer size);
}
