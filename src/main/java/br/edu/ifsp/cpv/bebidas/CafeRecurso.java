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
public class CafeRecurso {

	@Autowired
	CafeRepositorio cafesRepositorio;

	@GetMapping("/cafes")
	public ResponseEntity<List<Cafe>> recuperaCafes() {
		List<Cafe> cafes = cafesRepositorio.findAll();
		return new ResponseEntity<>(cafes, HttpStatus.OK);
	}

	@GetMapping("/cafes/{id}")
	public ResponseEntity<Cafe> recuperaCafe(@PathVariable long id) {
		Optional<Cafe> cafe = cafesRepositorio.findById(id);
		if (!cafe.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cafe.get(), HttpStatus.OK);
	}

	@PostMapping("/cafes")
	public ResponseEntity<Cafe> criaCafe(@RequestBody Cafe cafe) {
		Cafe criado = cafesRepositorio.save(cafe);
		return new ResponseEntity<>(criado, HttpStatus.CREATED);
	}

	@DeleteMapping("/cafes/{id}")
	public ResponseEntity<Object> deletaCafe(@PathVariable long id) {
		Optional<Cafe> cafeOptional = cafesRepositorio.findById(id);

		if (!cafeOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		cafesRepositorio.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/cafes/{id}")
	public ResponseEntity<Object> alteraCafe(@RequestBody Cafe cafe, @PathVariable long id) {

		Optional<Cafe> cafeOptional = cafesRepositorio.findById(id);
		if (!cafeOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}

		cafe.setId(id);
		cafesRepositorio.save(cafe);
		return ResponseEntity.noContent().build();
	}

}
