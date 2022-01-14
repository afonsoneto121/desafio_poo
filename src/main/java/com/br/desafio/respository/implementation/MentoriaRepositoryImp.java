package com.br.desafio.respository.implementation;

import com.br.desafio.entity.Mentoria;
import com.br.desafio.respository.MentoriaRepository;
import com.br.desafio.respository.generic.CrudRepository;
import com.br.desafio.respository.generic.CrudRepositoryImpFake;

public class MentoriaRepositoryImp extends CrudRepositoryImpFake<Mentoria, String> implements MentoriaRepository {
}
