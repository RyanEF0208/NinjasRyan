package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
