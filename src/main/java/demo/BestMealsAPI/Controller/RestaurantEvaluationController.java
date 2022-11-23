package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.RestaurantEvaluationDTO;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Model.RestaurantEvaluation;
import demo.BestMealsAPI.Repository.RestaurantEvaluationRepository;
import demo.BestMealsAPI.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RestaurantEvaluations")
public class RestaurantEvaluationController {

    @Autowired
    private RestaurantEvaluationRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    //Buscar Avaliação por ID
    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok(r))
                .orElse( ResponseEntity.notFound().build());
    }

    //Buscar todas as Avaliações de um restaurante
    @GetMapping("/Restaurant/{id}")
    public List<RestaurantEvaluation> searchEvaluations(@PathVariable("id") Integer id){
        return restaurantRepository.findById(id).get().getEvaluations();
    }

    //Insere uma Avaliação
    @PostMapping()
    public RestaurantEvaluation insert2(@RequestBody @Valid RestaurantEvaluationDTO evaluationDTO){
        Optional<Restaurant> aux = restaurantRepository.findById(evaluationDTO.getRestaurantId());
        if (!aux.isEmpty()){
            return repository.save(new RestaurantEvaluation(evaluationDTO, aux.get()));
        } else {
            throw new NullPointerException();
        }
    }

}
