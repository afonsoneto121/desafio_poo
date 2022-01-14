package com.br.desafio.service;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Curso;
import com.br.desafio.entity.Mentoria;
import com.br.desafio.respository.generic.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MentoriaService{
    Mentoria create(String title, String description, LocalDate date);
    Mentoria findById(String id);
    Mentoria update (String id, Mentoria mentoria);
    List<Mentoria> findAll();
    void delete(String id);
}
