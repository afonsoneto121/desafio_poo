package com.br.desafio.service;

import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Curso;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.generic.CrudRepository;

import java.util.List;

public interface DevService{
    Dev create(String nome);
    Dev findById(String id);
    Dev update (String id, Dev dev);
    List<Dev> findAll();
    void delete(String id);
    void addConteudoInscrito(String id, Conteudo conteudo);
    void addConteudoConcluido(String id, Conteudo conteudo);
}
