package demo.BestMealsAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Restaurant restaurant;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal cost;

    private String ingredients;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MealEvaluation> evaluations;


    public Meal() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public List<MealEvaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<MealEvaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
