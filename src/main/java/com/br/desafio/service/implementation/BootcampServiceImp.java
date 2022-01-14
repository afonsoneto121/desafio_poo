package com.br.desafio.service.implementation;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.BootcampRepository;
import com.br.desafio.service.BootcampService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class BootcampServiceImp implements BootcampService {
    private final BootcampRepository repository;
    public static final int MONTHS_TO_END_BOOTCAMP = 3;
    
    @Override
    public Bootcamp create(String nome, String descricao) {
        Bootcamp bootcamp = Bootcamp.builder()
                .nome(nome)
                .descricao(descricao)
                .dataInicial(LocalDate.now())
                .dataFinal(LocalDate.now().plusMonths(3))
                .conteudos(new HashSet<>())
                .devsInscritos(new HashSet<>())
                .build();
        bootcamp.setID(UUID.randomUUID().toString());
        repository.create(bootcamp);
        return bootcamp;
    }

    @Override
    public Bootcamp findById(String id) {
        Optional<Bootcamp> byId = repository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("Bootcamp not Found"));
    }

    @Override
    public Bootcamp update(String id, Bootcamp bootcamp) {
        Bootcamp update = repository.update(id, bootcamp);
        if(update == null) {
            throw  new RuntimeException("Bootcamp not Found");
        }
        return update;
    }

    @Override
    public List<Bootcamp> findAll() {
        return repository.findAll(Bootcamp.class);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void addInscrito(String id, Dev dev) {
        repository.addInscrito(id,dev);
    }

    @Override
    public void addConteudo(String id, Conteudo conteudo) {
        repository.addConteudo(id, conteudo);
    }
}
