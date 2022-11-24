package demo.BestMealsAPI.Repository;

import demo.BestMealsAPI.Model.MealEval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealEvalRepository extends CrudRepository<MealEval, Integer> {

    @Query("SELECT AVG(evaluation.evaluation) FROM MealEval where meal_Id = :id")
    double findmediaDasAvaliacoes(Integer id);

}
