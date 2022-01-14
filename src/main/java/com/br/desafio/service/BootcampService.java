package com.br.desafio.service;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;

import java.util.List;

public interface BootcampService {
    Bootcamp create(String nome, String descricao);
    Bootcamp findById(String id);
    Bootcamp update (String id, Bootcamp bootcamp);
    List<Bootcamp> findAll();
    void delete(String id);
    void addInscrito(String id, Dev dev);
    void addConteudo(String id, Conteudo conteudo);
}
