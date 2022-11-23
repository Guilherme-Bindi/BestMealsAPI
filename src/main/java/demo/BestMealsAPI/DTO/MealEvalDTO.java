package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.MealEval;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealEvalDTO {

    private int id;
    private int mealId;
    private int evaluation;
    private String comment;

    public MealEvalDTO(MealEval mealEval) {
        this.id = mealEval.getId();
        this.mealId = mealEval.getMeal().getId();
        this.evaluation = mealEval.getEvaluation().getEvaluation();
        this.comment = mealEval.getEvaluation().getComment();
    }
}
