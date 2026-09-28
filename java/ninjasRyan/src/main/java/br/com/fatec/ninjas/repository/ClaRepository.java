package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Cla;
import br.com.fatec.ninjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaRepository extends JpaRepository<Cla, Long> {

    Cla findByNome(String nome);

    List<Cla> findByDescricaoContaining(String descricao);
}
