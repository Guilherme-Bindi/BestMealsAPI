package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListaDTO {

    private List<Restaurant> lista;

    public ListaDTO(List<Restaurant> all) {
        lista = new ArrayList<>();
        all.forEach(r -> lista.add(r) );
    }

    public List<Restaurant> getLista() {
        return lista;
    }

    public void setLista(List<Restaurant> lista) {
        this.lista = lista;
    }
}
