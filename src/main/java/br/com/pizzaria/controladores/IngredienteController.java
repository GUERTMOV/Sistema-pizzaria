package br.com.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.repositorios.IngredientesRepositorios;

//  //app/ingredientes (metodo GET) -> listarIngredientes()

//	//app/ingredientes (metodo POST) -> salvarIngredientes()

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredientesRepositorios IngredientesRepositorios;

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes(Model model) {

		Iterable<Ingrediente> ingredientes = IngredientesRepositorios.findAll();

		model.addAttribute("titulo", "Listagem de Ingredientes");
		model.addAttribute("ingredientes", ingredientes);

		return "ingrediente/listagem";
		// WEB-INF/ingrediente/listagem.jsp
	}

}
