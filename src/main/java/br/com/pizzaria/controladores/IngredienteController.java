package br.com.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pizzaria.excecoes.IngredienteException;
import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.enumeracoes.CategoriaDeIngredientes;
import br.com.pizzaria.modelo.repositorios.IngredientesRepositorios;

//  //app/ingredientes (metodo GET) -> listarIngredientes()

//	//app/ingredientes (metodo POST) -> salvarIngredientes()

//http://localhost:8080/pizzaria/app/ingredientes

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
		model.addAttribute("categorias", CategoriaDeIngredientes.values());
		// WEB-INF/ingrediente/listagem.jsp
		return "ingrediente/listagem";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarIngredientes(@Valid @ModelAttribute Ingrediente ingrediente, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		if (bindingResult.hasErrors()) {
			throw new IngredienteException();
		} else {
			IngredientesRepositorios.save(ingrediente);
		}
		model.addAttribute("ingredientes", IngredientesRepositorios.findAll());
		model.addAttribute("categorias", CategoriaDeIngredientes.values());
		return "ingrediente/tabela-ingredientes";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarIgrediente(@PathVariable Long id) {
		try {
			IngredientesRepositorios.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id) {
		Ingrediente ingrediente = IngredientesRepositorios.findOne(id);
		return ingrediente;
	}

}
