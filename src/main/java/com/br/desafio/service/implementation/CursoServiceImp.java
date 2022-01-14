package com.br.desafio.service.implementation;

import com.br.desafio.entity.Curso;
import com.br.desafio.respository.CursoRepository;
import com.br.desafio.service.CursoService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {
    private final CursoRepository repository;
    @Override
    public Curso create(String title, String description, int cargaHoraria) {
        Curso curso = Curso.builder()
                .cargaHoraria(cargaHoraria)
                .build();
        curso.setTitulo(title);
        curso.setDescricao(description);
        curso.setID(UUID.randomUUID().toString());
        return repository.create(curso);
    }

    @Override
    public Curso findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Curso not found"));
    }

    @Override
    public Curso update(String id, Curso curso) {
        return repository.update(id, curso);
    }

    @Override
    public List<Curso> findAll() {
        return repository.findAll(Curso.class);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
