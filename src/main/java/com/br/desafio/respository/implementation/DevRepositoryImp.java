package com.br.desafio.respository.implementation;

import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.respository.DevRepository;
import com.br.desafio.respository.generic.CrudRepository;
import com.br.desafio.respository.generic.CrudRepositoryImpFake;

import java.util.stream.Collectors;

public class DevRepositoryImp extends CrudRepositoryImpFake<Dev, String> implements DevRepository {
    @Override
    public void addConteudoInscrito(String id, Conteudo conteudo) {
        dataBase = dataBase.stream().map(input -> {
            if(input.getID().equals(id)) {
                Dev dev = (Dev) input;
                dev.getConteudosInscritos().add(conteudo);
                return dev;
            }
            return input;
        }).collect(Collectors.toList());
    }

    @Override
    public void addConteudoConcluido(String id, Conteudo conteudo) {
        dataBase = dataBase.stream().map(input -> {
            if(input.getID().equals(id)) {
                Dev dev = (Dev) input;
                dev.getConteudosConcluidos().add(conteudo);
                return dev;
            }
            return input;
        }).collect(Collectors.toList());
    }
}
