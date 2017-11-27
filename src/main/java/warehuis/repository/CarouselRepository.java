package warehuis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import warehuis.models.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Long>{
	List<Carousel> findAll();
}
