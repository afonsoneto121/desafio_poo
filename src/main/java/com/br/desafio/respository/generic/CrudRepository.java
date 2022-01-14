package com.br.desafio.respository.generic;


import com.br.desafio.entity.GenericEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends GenericEntity,S> {
    T create(T t);
    Optional<T> findById(S id);
    List<T> findAll(Class<T> t);
    T update(S id, T t);
    void delete(S id);
}
