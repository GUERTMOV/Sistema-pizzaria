package br.com.pizzaria.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.repositorios.IngredientesRepositorios;

@Component
public class IngredientePropertyEditor extends PropertyEditorSupport {
	
	@Autowired
	private IngredientesRepositorios ingredienteRepositorio;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idIngrediente = Long.parseLong(text);
		Ingrediente ingrediente = ingredienteRepositorio.findOne(idIngrediente);
		setValue(ingrediente);
	}

}
