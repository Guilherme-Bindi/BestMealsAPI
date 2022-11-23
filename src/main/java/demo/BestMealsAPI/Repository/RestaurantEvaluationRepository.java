package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.RestaurantEvaluation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantEvaluationRepository extends CrudRepository<RestaurantEvaluation, Integer> {

    @Query("SELECT AVG(evaluation) FROM RestaurantEvaluation where RESTAURANT_ID = :id")
    double findmediaDasAvaliacoes(Integer id);
}
