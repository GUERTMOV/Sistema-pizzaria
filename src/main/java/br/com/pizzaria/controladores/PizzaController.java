package br.com.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pizzaria.excecoes.IngredienteException;
import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.entidades.Pizza;
import br.com.pizzaria.modelo.enumeracoes.CategoriaDePizza;
import br.com.pizzaria.modelo.servicos.ServicoIngrediente;
import br.com.pizzaria.modelo.servicos.ServicoPizza;
import br.com.pizzaria.propertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private IngredientePropertyEditor ingredientePropertyEditor;
	@Autowired
	private ServicoPizza servicoPizza;
	@Autowired
	private ServicoIngrediente servicoIngrediente;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPiazzas(Model model) {
		model.addAttribute("pizzas", servicoPizza.listar());
		model.addAttribute("categorias", CategoriaDePizza.values());
		model.addAttribute("ingredientes", servicoIngrediente.listar());
		return "pizza/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IngredienteException();
		} else {
			servicoPizza.salvar(pizza);
		}
		model.addAttribute("pizzas", servicoPizza.listar());
		return "pizza/tabela-pizzas";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long id) {
		try {
			servicoPizza.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Pizza> buscarPizza(@PathVariable Long id) {
		Pizza pizza = servicoPizza.buscar(id);
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}

}
