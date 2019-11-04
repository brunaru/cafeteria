package br.edu.ifsp.cpv;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.ifsp.cpv.bebidas.Bebida;
import br.edu.ifsp.cpv.bebidas.BebidaRepositorio;
import br.edu.ifsp.cpv.bebidas.Cafe;
import br.edu.ifsp.cpv.bebidas.Suco;
import br.edu.ifsp.cpv.pedidos.Pedido;
import br.edu.ifsp.cpv.pedidos.PedidoRepositorio;

@SpringBootApplication
public class CafeteriaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CafeteriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CafeteriaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BebidaRepositorio repositorio, PedidoRepositorio pedido) {
		return (args) -> {
			Cafe b1 = new Cafe("Expresso", 2.00, false, false);
			Cafe b2 = new Cafe("Latte", 3.00, true, false);
			Cafe b3 = new Cafe("Cappuccino", 3.50, true, false);
			Cafe b4 = new Cafe("Frappuccino", 6.00, true, true);
			
			Suco b5 = new Suco("Suco de Laranja", 3.00, false, 
					Arrays.asList("Laranja"));
			Suco b6 = new Suco("Suco de Vita C", 3.50, false, 
					Arrays.asList("Laranja", "Acerola"));
			Suco b7 = new Suco("Vitaminado", 7.00, true, 
					Arrays.asList("Maça", "Banana", "Morango"));
			
			repositorio.save(b1);
			repositorio.save(b2);
			repositorio.save(b3);
			repositorio.save(b4);
			
			repositorio.save(b5);
			repositorio.save(b6);
			repositorio.save(b7);
			
			Pedido p = new Pedido();
			p.setAcucar(true);
			p.setBebida(b4);
			p.setHorario(String.valueOf(System.currentTimeMillis()));
			p.setNomeCliente("Andino");
			pedido.save(p);

			log.info("BEBIDAS:");
			log.info("-------------------------------");
			for (Bebida bebida : repositorio.findAll()) {
				log.info("Nome: " + bebida.getNome());
			}
			log.info("------- FIM -------");
		};
	}


}
