package br.edu.ifsp.cpv.pedidos;

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
public class PedidoRecurso {

	@Autowired
	PedidoRepositorio repositorio;

	@GetMapping("/pedidos")
	List<Pedido> recuperaPedidos() {
		return repositorio.findAll();
	}

	@GetMapping("/pedidos/{id}")
	ResponseEntity<Pedido> recuperaPedido(@PathVariable long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		if (!pedido.isPresent()) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pedido>(pedido.get(), HttpStatus.OK);
	}

	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> criaPedido(@RequestBody Pedido pedido) {
		repositorio.save(pedido);
		return new ResponseEntity<Pedido>(HttpStatus.CREATED);
	}

	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<Object> deletaPedido(@PathVariable long id) {
		Optional<Pedido> pedidoOptional = repositorio.findById(id);

		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		repositorio.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/pedidos/{id}")
	public ResponseEntity<Object> alteraPedido(@RequestBody Pedido pedido, @PathVariable long id) {

		Optional<Pedido> pedidoOptional = repositorio.findById(id);
		if (!pedidoOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}

		pedido.setId(id);
		repositorio.save(pedido);
		return ResponseEntity.noContent().build();
	}
}
