package br.com.pizzaria.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.modelo.entidades.Pizzaria;

@Repository
public interface PizzariaRepositorio extends CrudRepository<Pizzaria, Long> {

	//@Query("SELECT p FROM Pizzaria p WHERE p.usuario.login = ?")
	public Pizzaria findOneBylogin(String login);

	//@Query("SELECT p1 FROM Pizzaria p1 INNER JOIN p1.pizzas p2 WHERE p2.nome = ?")
//	public List<Pizzaria> listarPizzariasPorNomePizza(String nomePizza);

}
