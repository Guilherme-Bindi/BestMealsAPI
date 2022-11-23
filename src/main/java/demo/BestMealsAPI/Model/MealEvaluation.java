package demo.BestMealsAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import demo.BestMealsAPI.DTO.MealEvaluationDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class MealEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Meal meal;

    @NotNull
    private int evaluation;

    private String comment;

    public MealEvaluation() {
    }

    public MealEvaluation(MealEvaluationDTO mealEvaluationDTO, Meal meal) {
        this.id = meal.getId();
        this.meal = meal;
        this.evaluation = mealEvaluationDTO.getEvaluation();
        this.comment = mealEvaluationDTO.getComment();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
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
