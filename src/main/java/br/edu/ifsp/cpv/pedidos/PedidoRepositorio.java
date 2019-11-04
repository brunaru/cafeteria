package br.edu.ifsp.cpv.pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{
	
	Pedido findByNomeCliente(String nome);

}
