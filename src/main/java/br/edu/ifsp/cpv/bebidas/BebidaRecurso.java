package br.edu.ifsp.cpv.bebidas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.cpv.bebidas.Bebida;


@RestController
public class BebidaRecurso {
	
	@Autowired
	BebidaRepositorio bebidasRepositorio;
	
	@GetMapping("/bebidas")
	public ResponseEntity<List<Bebida>> recuperaBebidas(@RequestParam(required = false) String nome) {
		if(nome == null) {
			List<Bebida> bebidas = bebidasRepositorio.findAll();
			return new ResponseEntity<>(bebidas, HttpStatus.OK);
		} else {
			Bebida bebida = bebidasRepositorio.findByNome(nome);
			if (bebida == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(Arrays.asList(bebida), HttpStatus.OK);
		}
	}
	
	@GetMapping("/bebidas/{id}")
	public ResponseEntity<Bebida> recuperaBebida(@PathVariable long id) {
		Optional<Bebida> bebida = bebidasRepositorio.findById(id);
		if (!bebida.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bebida>(bebida.get(), HttpStatus.OK);
	}
}
