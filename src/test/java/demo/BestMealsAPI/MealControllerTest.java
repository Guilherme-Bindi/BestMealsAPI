package demo.BestMealsAPI;

import demo.BestMealsAPI.Controller.MealController;
import demo.BestMealsAPI.Model.Evaluation;
import demo.BestMealsAPI.Model.Meal;
import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Repository.MealEvalRepository;
import demo.BestMealsAPI.Repository.MealRepository;
import org.assertj.core.api.DoubleAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MealControllerTest {

    @Autowired
    private MealEvalRepository mealEvalRepository;


    @Test
    public void VerificaID(){
        Assertions.assertEquals(
                mealEvalRepository.findById(1).get().getId(),
                1
        );
    }

}
