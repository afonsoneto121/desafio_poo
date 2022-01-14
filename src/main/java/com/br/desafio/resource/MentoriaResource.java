package com.br.desafio.resource;

import com.br.desafio.entity.Mentoria;
import com.br.desafio.service.MentoriaService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class MentoriaResource {
    private final MentoriaService service;

    public Mentoria create(String title, String description, LocalDate date) {
        if( title.isEmpty() || description.isEmpty()) throw new RuntimeException("Description or name is empty");
        return service.create(title,description, date);
    }

    public Mentoria findById(String id) {
        return service.findById(id);
    }

    public Mentoria update(String id, Mentoria mentoria) {
        return service.update(id,mentoria);
    }

    public List<Mentoria> findAll() {
        return service.findAll();
    }

    public void delete(String id) {
        service.delete(id);
    }
}
