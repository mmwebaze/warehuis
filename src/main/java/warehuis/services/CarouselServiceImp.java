package warehuis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehuis.models.Carousel;
import warehuis.repository.CarouselRepository;
@Service
public class CarouselServiceImp implements CarouselService{
	@Autowired
	private CarouselRepository carouselRepository;

	@Override
	public List<Carousel> getAllCarousels(Integer page, Integer size) {
		List<Carousel> pageOfCarousels = this.carouselRepository.findAll();
		return pageOfCarousels;
	}
	public Carousel save(Carousel carousel) {
		return this.carouselRepository.save(carousel);
	}

}
