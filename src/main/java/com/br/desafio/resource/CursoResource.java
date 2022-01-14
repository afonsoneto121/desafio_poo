package com.br.desafio.resource;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Curso;
import com.br.desafio.service.CursoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CursoResource {
    private final CursoService service;

    public Curso create(String title, String description, int cargaHoraria) {
        if( title.isEmpty() || description.isEmpty()) throw new RuntimeException("Description or name is empty");
        return service.create(title,description,cargaHoraria);
    }

    public Curso findById(String id) {
        return service.findById(id);
    }

    public Curso update(String id, Curso curso) {
        return service.update(id,curso);
    }

    public List<Curso> findAll() {
        return service.findAll();
    }

    public void delete(String id) {
        service.delete(id);
    }
}
