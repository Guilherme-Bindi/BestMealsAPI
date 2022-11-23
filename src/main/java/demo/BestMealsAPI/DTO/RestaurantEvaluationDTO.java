package demo.BestMealsAPI.DTO;

import javax.validation.constraints.NotNull;

public class RestaurantEvaluationDTO {

    @NotNull
    private int restaurantId;
    @NotNull
    private int evaluation;

    private String comment;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
