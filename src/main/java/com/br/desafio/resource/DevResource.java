package com.br.desafio.resource;

import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.service.DevService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DevResource {
    private final DevService service;

    public Dev create(String name) {
        if( name.isEmpty() ) throw new RuntimeException("Description or name is empty");
        return service.create(name);
    }

    public Dev findById(String id) {
        return service.findById(id);
    }

    public Dev update(String id, Dev Dev) {
        return service.update(id,Dev);
    }

    public List<Dev> findAll() {
        return service.findAll();
    }

    public void delete(String id) {
        service.delete(id);
    }

    public void addConteudoInscrito(String id, Conteudo conteudo) {
        service.addConteudoInscrito(id, conteudo);
    }
    public void addConteudoConcluido(String id, Conteudo conteudo){
        service.addConteudoConcluido(id, conteudo);
    }
}
