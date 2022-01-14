package com.br.desafio.entity;

import lombok.*;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.Set;

@Data()
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp extends GenericEntity{
    private String nome;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Set<Dev> devsInscritos;
    private Set<Conteudo> conteudos;

}