package com.br.desafio.respository.implementation;

import com.br.desafio.entity.Bootcamp;
import com.br.desafio.entity.Conteudo;
import com.br.desafio.entity.Dev;
import com.br.desafio.entity.GenericEntity;
import com.br.desafio.respository.BootcampRepository;
import com.br.desafio.respository.generic.CrudRepositoryImpFake;

import java.util.stream.Collectors;

public class BootcampRepositoryImp
        extends CrudRepositoryImpFake<Bootcamp, String>
        implements BootcampRepository {

    @Override
    public void addInscrito(String id, Dev dev) {
        dataBase = dataBase.stream().map(value -> {
            if(value.getID().equals(id)) {
                Bootcamp bootcamp = (Bootcamp) value;
                bootcamp.getDevsInscritos().add(dev);
                return bootcamp;
            }
            return  value;
        }).collect(Collectors.toList());
    }

    @Override
    public void addConteudo(String id,Conteudo conteudo) {
        dataBase = dataBase.stream().map(value -> {
            if(value.getID().equals(id)) {
                Bootcamp bootcamp = (Bootcamp) value;
                bootcamp.getConteudos().add(conteudo);
                return bootcamp;
            }
            return  value;
        }).collect(Collectors.toList());
    }
}
