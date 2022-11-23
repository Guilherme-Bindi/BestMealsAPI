package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.Meal;

import java.math.BigDecimal;

public class MealDTO {

    private int id;
    private int restaurantId;
    private String name;
    private BigDecimal cost;
    private String ingredients;

//    private List<MealEvaluation> evaluations;


    public MealDTO() {
    }

    public MealDTO(Meal meal) {
        this.id = meal.getId();
        this.restaurantId = meal.getRestaurant().getId();
        this.name = meal.getName();
        this.cost = meal.getCost();
        this.ingredients = meal.getIngredients();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
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
}
