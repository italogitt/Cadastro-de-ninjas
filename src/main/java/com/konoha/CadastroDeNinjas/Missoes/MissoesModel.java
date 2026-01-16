package com.konoha.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konoha.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "descricao")
    private String descricao;


    @Column(name = "dificuldade")
    private char dificuldade;


    //@OneToMany - Uma missoa pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    @Column(name = "ninjas")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
