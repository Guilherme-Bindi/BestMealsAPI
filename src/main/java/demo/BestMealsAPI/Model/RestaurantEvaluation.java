package demo.BestMealsAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import demo.BestMealsAPI.DTO.RestaurantEvaluationDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class RestaurantEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Restaurant restaurant;

    @NotNull
    private int evaluation;
    private String comment;

    public RestaurantEvaluation() {
    }

    //Cadastra avaliação com DTO e restaurant
    public RestaurantEvaluation(RestaurantEvaluationDTO evaluationDTO, Restaurant restaurant) {
        this.restaurant = restaurant;
        this.evaluation = evaluationDTO.getEvaluation();
        this.comment = evaluationDTO.getComment();
    }

    public int getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
