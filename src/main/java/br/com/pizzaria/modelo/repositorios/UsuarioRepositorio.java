package br.com.pizzaria.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.modelo.entidades.Ususario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Ususario, Long> {

	public UserDetails findOneBylogin(String login);
	
	
	

}
