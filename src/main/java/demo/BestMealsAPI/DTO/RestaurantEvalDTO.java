package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Model.RestaurantEval;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEvalDTO {

    private int id;
    private int restaurantId;
    private int evaluation;
    private String comment;

    public RestaurantEvalDTO(RestaurantEval restaurantEval) {
        this.id = restaurantEval.getId();
        this.restaurantId = restaurantEval.getRestaurant().getId();
        this.evaluation = restaurantEval.getEvaluation().getEvaluation();
        this.comment = restaurantEval.getEvaluation().getComment();
    }
}
