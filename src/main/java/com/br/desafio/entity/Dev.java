package com.br.desafio.entity;

import lombok.*;

import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Dev extends GenericEntity{
    private String nome;
    private Set<Conteudo> conteudosInscritos;
    private Set<Conteudo> conteudosConcluidos;
}