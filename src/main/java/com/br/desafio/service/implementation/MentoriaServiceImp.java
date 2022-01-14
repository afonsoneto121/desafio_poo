package com.br.desafio.service.implementation;

import com.br.desafio.entity.Mentoria;
import com.br.desafio.respository.MentoriaRepository;
import com.br.desafio.service.MentoriaService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class MentoriaServiceImp implements MentoriaService {
    private final MentoriaRepository repository;
    @Override
    public Mentoria create(String title, String description, LocalDate date) {
        Mentoria mentoria = Mentoria.builder()
                .data(date).build();
        mentoria.setTitulo(title);
        mentoria.setDescricao(description);
        mentoria.setID(UUID.randomUUID().toString());

        return repository.create(mentoria);
    }

    @Override
    public Mentoria findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Mentoria not found"));
    }

    @Override
    public Mentoria update(String id, Mentoria mentoria) {
        return repository.update(id,mentoria);
    }

    @Override
    public List<Mentoria> findAll() {
        return repository.findAll(Mentoria.class);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
