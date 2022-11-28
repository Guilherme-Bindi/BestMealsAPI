package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.ListaDTO;
import demo.BestMealsAPI.DTO.RestaurantDTO;
import demo.BestMealsAPI.Model.Restaurant;
import demo.BestMealsAPI.Repository.RestaurantEvalRepository;
import demo.BestMealsAPI.Repository.RestaurantEvaluationRepository;
import demo.BestMealsAPI.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private RestaurantEvalRepository restaurantEvalRepository;

    //Busca objeto por ID
    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/DTO/{id}")
    public RestaurantDTO searchDTO(@PathVariable("id") Integer id){
        return new RestaurantDTO( repository.findById(id).get() );
    }


    //Busca todos os restaurantes que contenham parte do nome
    @GetMapping("/nome/{name}")
    public List<Restaurant> searchName(@PathVariable("name") String name){
        return repository.findBynameContainingIgnoreCase(name);
    }

    //Busca todos os restaurante e retorna Pageable
    @GetMapping("/Pageable")
    public Page<RestaurantDTO> serachAllPageable(Pageable pageable){
        return repository.findAll(pageable).map(RestaurantDTO::new);
    }

    //Retorna Lista com todos os restaurantes
    @GetMapping("all")
    public ListaDTO searchAll(){
        return new ListaDTO( repository.findAll() );
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

    //Calcula a média das avaliações por Restaurant
    @GetMapping("/mediaEvaluations/{id}")
    public double mediaEvaluations(@PathVariable("id") Integer id){
        return restaurantEvaluationRepository.findmediaDasAvaliacoes(id);
    }

    @GetMapping("/mediaEval/{id}")
    public double mediaEval(@PathVariable("id") Integer id){
        return restaurantEvalRepository.findmediaDasAvaliacoes(id);
    }

}
