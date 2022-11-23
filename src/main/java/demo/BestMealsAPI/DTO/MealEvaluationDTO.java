package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.MealEvaluation;

import javax.validation.constraints.NotNull;

public class MealEvaluationDTO {

    private int id;
    @NotNull
    private int mealId;
    @NotNull
    private int evaluation;

    private String comment;


    public MealEvaluationDTO() {
    }

    public MealEvaluationDTO(MealEvaluation mealEvaluation) {
        this.id = mealEvaluation.getId();
        this.mealId = mealEvaluation.getMeal().getId();
        this.evaluation = mealEvaluation.getEvaluation();
        this.comment = mealEvaluation.getComment();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
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
