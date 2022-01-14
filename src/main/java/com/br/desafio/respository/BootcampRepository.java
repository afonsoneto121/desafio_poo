package com.br.desafio.respository;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.generic.CrudRepository;

public interface BootcampRepository extends CrudRepository<Bootcamp, String> {
    void addInscrito(String id,Dev dev);
    void addConteudo(String id,Conteudo conteudo);
}
