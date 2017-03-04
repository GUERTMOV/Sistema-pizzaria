package br.com.pizzaria.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.modelo.entidades.Ingrediente;

@Repository
public interface IngredientesRepositorios extends CrudRepository<Ingrediente, Long> {

}
