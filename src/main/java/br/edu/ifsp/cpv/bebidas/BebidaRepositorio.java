package br.edu.ifsp.cpv.bebidas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepositorio extends JpaRepository<Bebida, Long> {
	
	public Bebida findByNome(String nome);

}
