package demo.BestMealsAPI.Controller;

import demo.BestMealsAPI.DTO.MealEvaluationDTO;
import demo.BestMealsAPI.Model.Meal;
import demo.BestMealsAPI.Model.MealEvaluation;
import demo.BestMealsAPI.Repository.MealEvaluationRepository;
import demo.BestMealsAPI.Repository.MealRepository;
import demo.BestMealsAPI.Model.MealEval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MealEvaluations")
public class MealEvaluationController {

    @Autowired
    private MealEvaluationRepository repository;

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id){
        return repository.findById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse( ResponseEntity.notFound().build() );
    }

    //Buscar todas as Avaliações de um restaurante
    @GetMapping("/Meal/{id}")
    public List<MealEval> searchEvaluations(@PathVariable("id") Integer id){
        return mealRepository.findById(id).get().getEvaluations();
    }

    //Cadastra nova avaliação
    @PostMapping
    public MealEvaluation insert(@RequestBody MealEvaluationDTO mealEvaluationDTO){
        Optional<Meal> aux = mealRepository.findById(mealEvaluationDTO.getMealId());
        if (!aux.isEmpty()){
            return repository.save(new MealEvaluation(mealEvaluationDTO,aux.get()));
        } else {
            throw new NullPointerException();
        }
    }

    //Altera uma avaliação
    @PutMapping
    public MealEvaluation update(@RequestBody MealEvaluation mealEvaluation){
        return repository.save(mealEvaluation);
    }

    //Apaga avaliação por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
}
