package br.com.pizzaria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pizzaria.modelo.repositorios.UsuarioRepositorio;

@Service
public class ServicoAutenticacao implements UserDetailsService {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return usuarioRepositorio.findOneBylogin(login);
	}

}
