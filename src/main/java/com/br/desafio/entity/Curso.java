package com.br.desafio.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Curso extends Conteudo {
    private int cargaHoraria;

}