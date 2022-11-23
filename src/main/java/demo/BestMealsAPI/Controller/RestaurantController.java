package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.RestaurantDTO;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Repository.RestaurantEvaluationRepository;
import demo.BestMealsAPI.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private RestaurantEvaluationRepository restaurantEvaluationRepository;

    //Busca objeto por ID
    @GetMapping("/{id}")
    private ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse(ResponseEntity.notFound().build());
    }

    //Busca todos os restaurantes que contenham parte do nome
    @GetMapping("/nome/{name}")
    public List<Restaurant> searchName(@PathVariable("name") String name){
        return repository.findBynameContainingIgnoreCase(name);
    }

    //Cadastra novo objeto
    @PostMapping
    public Restaurant insert(@RequestBody @Valid Restaurant restaurant){
        return repository.save(restaurant);
    }

    //Salvar objeto
    @PutMapping
    public Restaurant update(@RequestBody @Valid Restaurant restaurant){
        return repository.save(restaurant);
    }


    //Apaga objeto sem retornar valor
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    //Apaga objeto retornando o objeto apagado
    @DeleteMapping("/remover/{id}")
    public Optional<Restaurant> remove(@PathVariable("id") Integer id){
        Optional<Restaurant> aux = repository.findById(id);
        if (!aux.isEmpty()) {
            repository.deleteById(id);
            return aux;
        } else {
            return null;
        }
    }

    @GetMapping("/mediaEvaluations/{id}")
    public double mediaEvaluations(@PathVariable("id") Integer id){
        return restaurantEvaluationRepository.findmediaDasAvaliacoes(id);
    }

}
