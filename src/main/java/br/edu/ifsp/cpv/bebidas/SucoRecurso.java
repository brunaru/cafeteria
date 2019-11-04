package br.edu.ifsp.cpv.bebidas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SucoRecurso {

	@Autowired
	SucoRepositorio sucosRepositorio;

	@GetMapping("/sucos")
	public ResponseEntity<List<Suco>> recuperaSucos() {
		List<Suco> sucos = sucosRepositorio.findAll();
		return new ResponseEntity<>(sucos, HttpStatus.OK);
	}

	@GetMapping("/sucos/{id}")
	public ResponseEntity<Suco> recuperaSuco(@PathVariable long id) {
		Optional<Suco> suco = sucosRepositorio.findById(id);
		if (!suco.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(suco.get(), HttpStatus.OK);
	}

	@PostMapping("/sucos")
	public ResponseEntity<Suco> criaSuco(@RequestBody Suco suco) {
		Suco criado = sucosRepositorio.save(suco);
		return new ResponseEntity<>(criado, HttpStatus.CREATED);
	}

	@DeleteMapping("/sucos/{id}")
	public ResponseEntity<Object> deletaSuco(@PathVariable long id) {
		Optional<Suco> sucoOptional = sucosRepositorio.findById(id);

		if (!sucoOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		sucosRepositorio.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/sucos/{id}")
	public ResponseEntity<Object> alteraSuco(@RequestBody Suco suco, @PathVariable long id) {

		Optional<Suco> sucoOptional = sucosRepositorio.findById(id);
		if (!sucoOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}

		suco.setId(id);
		sucosRepositorio.save(suco);
		return ResponseEntity.noContent().build();
	}

}
