package com.br.desafio.respository.generic;

import com.br.desafio.entity.GenericEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CrudRepositoryImpFake<T extends  GenericEntity, S> implements CrudRepository<T, S> {
    protected static List<GenericEntity> dataBase = new ArrayList<>();

    @Override
    public T create(T t) {
        dataBase.add(t);
        return t;
    }

    @Override
    public Optional<T> findById(S id) {
        return (Optional<T>) dataBase.stream().filter(value -> value.getID().equals(id)).findFirst();
    }

    @Override
    public List<T> findAll(Class<T> t) {
        return (List<T>) dataBase.stream().filter(value -> t.isInstance(value)).collect(Collectors.toList());
    }

    @Override
    public T update(S id, T t) {
        Optional<T> byId = this.findById(id);
        if(byId.isEmpty()) {
            return null;
        }
        dataBase = dataBase.stream().map(value -> {
            if(value.getID().equals(byId.get().getID())) {
                return byId.get();
            }
            return value;
        }).collect(Collectors.toList());

        return t;
    }

    @Override
    public void delete(S id) {
        Optional<T> byId = this.findById(id);
        if(byId.isEmpty()) {
            return;
        }
        dataBase = dataBase.stream().filter(value -> {
            if(value.getID().equals(byId.get().getID())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }
    public static void close(){
        dataBase = new ArrayList<>();
    }
}
