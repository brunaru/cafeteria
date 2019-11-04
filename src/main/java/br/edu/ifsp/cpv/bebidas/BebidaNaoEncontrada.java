package br.edu.ifsp.cpv.bebidas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "bebida nao encomtrada")
public class BebidaNaoEncontrada extends RuntimeException {

	private static final long serialVersionUID = 5781850998664172507L;

}
