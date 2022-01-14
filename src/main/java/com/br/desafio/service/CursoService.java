package com.br.desafio.service;

import com.br.desafio.entity.Curso;
import com.br.desafio.entity.Curso;
import com.br.desafio.respository.generic.CrudRepository;

import java.util.List;

public interface CursoService {
    Curso create(String title, String description, int cargaHoraria);
    Curso findById(String id);
    Curso update (String id, Curso curso);
    List<Curso> findAll();
    void delete(String id);
}
