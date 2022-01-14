package com.br.desafio.service.implementation;

import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.DevRepository;
import com.br.desafio.service.DevService;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class DevServiceImp implements DevService {
    private final DevRepository repository;
    @Override
    public Dev create(String nome) {
        Dev dev = Dev.builder()
                .nome(nome)
                .conteudosConcluidos(new HashSet<>())
                .conteudosInscritos(new HashSet<>())
                .build();
        dev.setID(UUID.randomUUID().toString());
        return repository.create(dev);
    }

    @Override
    public Dev findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Dev not found"));
    }

    @Override
    public Dev update(String id, Dev dev) {
        return repository.update(id,dev);
    }

    @Override
    public List<Dev> findAll() {
        return repository.findAll(Dev.class);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void addConteudoInscrito(String id, Conteudo conteudo) {
        repository.addConteudoInscrito(id, conteudo);
    }

    @Override
    public void addConteudoConcluido(String id, Conteudo conteudo) {
        repository.addConteudoConcluido(id, conteudo);
    }
}
