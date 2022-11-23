package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.Meal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer> {

    List<Meal> findByRestaurantId(Integer id);
}