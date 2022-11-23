package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.RestaurantEvalDTO;
import demo.BestMealsAPI.Model.Meal;
import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Model.RestaurantEval;
import demo.BestMealsAPI.Repository.MealRepository;
import demo.BestMealsAPI.DTO.MealEvalDTO;
import demo.BestMealsAPI.Repository.MealEvalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/MealEval")
public class MealEvalController {

    @Autowired
    private MealEvalRepository repository;

    @Autowired
    private MealRepository mealRepository;


    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse( ResponseEntity.notFound().build() );
    }

    @GetMapping("/DTO/{id}")
    public MealEvalDTO searchDTO(@PathVariable("id") Integer id){
        return new MealEvalDTO(repository.findById(id).get());
    }

    @PostMapping
    public MealEval insert(@RequestBody MealEvalDTO mealEvalDTO){
        Optional<Meal> meal = mealRepository.findById(mealEvalDTO.getMealId());
        if (!meal.isEmpty()){
            return repository.save( new MealEval(mealEvalDTO, meal.get()) );
        } else {
            throw new NullPointerException();
        }
    }

    @PostMapping("/DTO")
    public MealEvalDTO insertDTO(@RequestBody MealEvalDTO mealEvalDTO){
        Optional<Meal> meal = mealRepository.findById(mealEvalDTO.getMealId());
        if (!meal.isEmpty()){
            return new MealEvalDTO( repository.save( new MealEval(mealEvalDTO, meal.get()) ) );
        } else {
            throw new NullPointerException();
        }
    }

    @PutMapping
    public MealEval update(@RequestBody MealEvalDTO mealEvalDTO){
        Optional<Meal> meal = mealRepository.findById(mealEvalDTO.getMealId());
        if (!meal.isEmpty()){
            return repository.save( new MealEval(mealEvalDTO, meal.get()) );
        } else {
            throw new NullPointerException();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

}
