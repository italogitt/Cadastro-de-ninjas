package com.konoha.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konoha.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    DTO é uma Camada de abstração: Uma camada usada como uma espécia de "barreira" para proteger o
    banco de dados da nossa aplicação.

    Basicamente, ele é uma cópia do seu Model, mas sem acesso ao seu banco de dados. Isso protege
    seu sistema de possíveis usuários mal intecionados.
    */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesDTO {

    private Long id;

    private String nome;

    private String descricao;

    private String dificuldade;

    private List<NinjaModel> ninjas;

}
