package br.edu.ifsp.cpv.bebidas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepositorio extends JpaRepository<Cafe, Long> {

}
