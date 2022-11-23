package demo.BestMealsAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    private int evaluation;

    private String comment;

}
