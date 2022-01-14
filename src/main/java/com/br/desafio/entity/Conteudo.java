package com.br.desafio.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Conteudo extends GenericEntity{

    private String titulo;
    private String descricao;
}