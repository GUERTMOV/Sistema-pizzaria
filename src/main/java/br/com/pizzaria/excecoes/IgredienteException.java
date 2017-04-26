package br.com.pizzaria.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IgredienteException extends RuntimeException {

	private static final long serialVersionUID = 4165423435052178693L;

}
