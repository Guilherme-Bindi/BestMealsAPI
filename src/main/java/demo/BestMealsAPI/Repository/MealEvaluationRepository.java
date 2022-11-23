package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.MealEvaluation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MealEvaluationRepository extends CrudRepository<MealEvaluation, Integer> {

    @Query("SELECT AVG(evaluation) FROM MealEvaluation where MEAL_ID = :id")
    double findmediaDasAvaliacoes(Integer id);
}
