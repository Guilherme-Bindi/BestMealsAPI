package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Model.RestaurantEval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantEvalRepository extends CrudRepository<RestaurantEval, Integer> {

    @Query("SELECT AVG(evaluation.evaluation) FROM RestaurantEval where RESTAURANT_ID = :id")
    double findmediaDasAvaliacoes(Integer id);
}
