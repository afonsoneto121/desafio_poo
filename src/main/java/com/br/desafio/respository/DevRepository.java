package com.br.desafio.respository;

import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.generic.CrudRepository;

public interface DevRepository extends CrudRepository<Dev, String> {
    void addConteudoInscrito(String id, Conteudo conteudo);
    void addConteudoConcluido(String id, Conteudo conteudo);
}
