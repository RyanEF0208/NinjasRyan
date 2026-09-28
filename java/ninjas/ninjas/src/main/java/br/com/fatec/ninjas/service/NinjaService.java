package br.com.fatec.ninjas.service;


import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarninja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
