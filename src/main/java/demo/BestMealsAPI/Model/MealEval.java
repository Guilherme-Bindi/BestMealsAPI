package demo.BestMealsAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import demo.BestMealsAPI.DTO.MealEvalDTO;
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
public class MealEval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private Meal meal;

    @Embedded
    private Evaluation evaluation;

    public MealEval(MealEvalDTO mealEvalDTO, Meal meal) {
        this.id = mealEvalDTO.getId();
        this.meal = meal;
        this.evaluation = new Evaluation(mealEvalDTO.getEvaluation(),mealEvalDTO.getComment());
    }
}
