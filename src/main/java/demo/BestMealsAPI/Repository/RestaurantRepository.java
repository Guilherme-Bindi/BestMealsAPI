package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findBynameContainingIgnoreCase (String name);

}
