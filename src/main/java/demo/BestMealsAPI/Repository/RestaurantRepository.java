package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findBynameContainingIgnoreCase (String name);

}
