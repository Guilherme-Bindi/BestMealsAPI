package demo.BestMealsAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import demo.BestMealsAPI.DTO.MealEvalDTO;
import demo.BestMealsAPI.DTO.RestaurantEvalDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Restaurant restaurant;

    @Embedded
    private Evaluation evaluation;

    public RestaurantEval(RestaurantEvalDTO restaurantEvalDTO, Restaurant restaurant) {
        this.id = restaurantEvalDTO.getId();
        this.restaurant = restaurant;
        this.evaluation = new Evaluation(restaurantEvalDTO.getEvaluation(),restaurantEvalDTO.getComment());
    }
}
