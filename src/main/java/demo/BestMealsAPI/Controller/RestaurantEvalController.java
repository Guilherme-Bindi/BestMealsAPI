package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.MealEvalDTO;
import demo.BestMealsAPI.DTO.RestaurantEvalDTO;
import demo.BestMealsAPI.Model.Meal;
import demo.BestMealsAPI.Model.MealEval;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Model.RestaurantEval;
import demo.BestMealsAPI.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/RestaurantEval")
public class RestaurantEvalController {

    @Autowired
    private RestaurantEvalRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;


    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse( ResponseEntity.notFound().build() );
    }

    @GetMapping("/DTO/{id}")
    public RestaurantEvalDTO searchDTO(@PathVariable("id") Integer id){
        return new RestaurantEvalDTO(repository.findById(id).get());
    }

    @PostMapping
    public RestaurantEval insert(@RequestBody RestaurantEvalDTO restaurantEvalDTO){
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantEvalDTO.getRestaurantId());
        if (!restaurant.isEmpty()){
            return repository.save( new RestaurantEval(restaurantEvalDTO, restaurant.get()) );
        } else {
            throw new NullPointerException();
        }
    }

    @PostMapping("/DTO")
    public RestaurantEvalDTO insertDTO(@RequestBody RestaurantEvalDTO restaurantEvalDTO){
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantEvalDTO.getRestaurantId());
        if (!restaurant.isEmpty()){
            return new RestaurantEvalDTO( repository.save( new RestaurantEval(restaurantEvalDTO, restaurant.get()) ) );
        } else {
            throw new NullPointerException();
        }
    }

    @PutMapping
    public RestaurantEval update(@RequestBody RestaurantEvalDTO restaurantEvalDTO){
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantEvalDTO.getRestaurantId());
        if (!restaurant.isEmpty()){
            return repository.save( new RestaurantEval(restaurantEvalDTO, restaurant.get()) );
        } else {
            throw new NullPointerException();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

}
