package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Model.RestaurantEval;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantEvalRepository extends CrudRepository<RestaurantEval, Integer> {
}
