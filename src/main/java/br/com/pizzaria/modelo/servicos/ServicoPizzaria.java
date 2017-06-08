package br.com.pizzaria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.pizzaria.modelo.entidades.Pizzaria;
import br.com.pizzaria.modelo.repositorios.PizzariaRepositorio;

@Service
public class ServicoPizzaria {

	@Autowired
	private PizzariaRepositorio pizzariaRepositorio;

	public Pizzaria getPizzariaLogada() {
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if (autenticado == null)
			throw new AuthenticationCredentialsNotFoundException("Usuario nao logado");
		UserDetails usuarioLogado = (UserDetails) autenticado.getPrincipal();
		return pizzariaRepositorio.findOneBylogin(usuarioLogado.getUsername());
	}

}
