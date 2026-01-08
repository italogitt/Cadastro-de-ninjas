package com.konoha.CadastroDeNinjas.Missoes;

import com.konoha.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private char ranking;

    //@OneToMany - Uma missoa pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissoesModel(){}

    public MissoesModel(long id, String descricao, char ranking) {
        this.id = id;
        this.descricao = descricao;
        this.ranking = ranking;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getRanking() {
        return ranking;
    }

    public void setRanking(char ranking) {
        this.ranking = ranking;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "MissoesModel{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
