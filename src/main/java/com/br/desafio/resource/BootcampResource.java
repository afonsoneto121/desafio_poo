package com.br.desafio.resource;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.service.BootcampService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BootcampResource {
    private final BootcampService service;

    public Bootcamp create(String name, String description) {
        if( name.isEmpty() || description.isEmpty()) throw new RuntimeException("Description or name is empty");
        return service.create(name,description);
    }

    public Bootcamp findById(String id) {
        return service.findById(id);
    }

    public Bootcamp update(String id, Bootcamp bootcamp) {
        return service.update(id,bootcamp);
    }

    public List<Bootcamp> findAll() {
        return service.findAll();
    }

    public void delete(String id) {
        service.delete(id);
    }
    public void addInscrito(String id, Dev dev){
        service.addInscrito(id, dev);
    }
    public void addConteudo(String id, Conteudo conteudo){
        service.addConteudo(id, conteudo);
    }
}
