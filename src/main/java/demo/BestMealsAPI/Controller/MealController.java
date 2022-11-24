package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.MealDTO;
import demo.BestMealsAPI.Model.Meal;
import demo.BestMealsAPI.Model.MealEvaluation;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Repository.MealEvalRepository;
import demo.BestMealsAPI.Repository.MealEvaluationRepository;
import demo.BestMealsAPI.Repository.MealRepository;
import demo.BestMealsAPI.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Meal")
public class MealController {

    @Autowired
    private MealRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MealEvaluationRepository mealEvaluationRepository;

    @Autowired
    private MealEvalRepository mealEvalRepository;


    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map( r-> ResponseEntity.ok().body(r))
                .orElse( ResponseEntity.notFound().build() );
    }

    //Retorna DTO do Mael
    @GetMapping("/DTO/{id}")
    public MealDTO searchDTO(@PathVariable("id") Integer id){
        return new MealDTO(repository.findById(id).get());
    }


    //Retorna todos os meals de um restaurant
    @GetMapping("/restaurant/{id}")
    public List<Meal> searchRestaurant(@PathVariable("id") Integer id){
        return repository.findByRestaurantId(id);
    }

    @GetMapping("/restaurantDTO/{id}")
    public List<MealDTO> searchRestaurantDTO(@PathVariable("id") Integer id){
        List<MealDTO> aux = new ArrayList<>();
        repository.findByRestaurantId(id).forEach(r -> aux.add( new MealDTO(r) ) );

        return aux;
    }

    //Cadastra um novo meal
    @PostMapping
    public Meal insert(@RequestBody @Valid MealDTO mealDTO){
        Optional<Restaurant> aux = restaurantRepository.findById(mealDTO.getRestaurantId());
        if (!aux.isEmpty()){
            return repository.save( new Meal(mealDTO,aux.get()) );
        }
        return null;
    }

    //Altera o cadastro do meal
    @PutMapping
    public Meal update(@RequestBody @Valid Meal meal){
        return repository.save(meal);
    }

    //Apaga uma Meal por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    //Apaga com retorno do objeto apagado
    @DeleteMapping("/remover/{id}")
    public Optional<Meal> remove(@PathVariable("id") Integer id){
        Optional<Meal> aux = repository.findById(id);
        if (!aux.isEmpty()) {
            repository.deleteById(id);
            return aux;
        } else {
            return null;
        }
    }

    //Calcula a média das avaliações por Meal
    @GetMapping("/mediaEvaluations/{id}")
    public double mediaEvaluations(@PathVariable("id") Integer id){
        return mealEvaluationRepository.findmediaDasAvaliacoes(id);
    }

    @GetMapping("/mediaEval/{id}")
    public double mediaEval(@PathVariable("id") Integer id){
        return mealEvalRepository.findmediaDasAvaliacoes(id);
    }
}
