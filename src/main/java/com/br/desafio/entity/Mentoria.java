package com.br.desafio.entity;

import lombok.*;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Mentoria extends Conteudo {
    private LocalDate data;

}