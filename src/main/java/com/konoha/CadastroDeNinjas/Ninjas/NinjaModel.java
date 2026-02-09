package com.konoha.CadastroDeNinjas.Ninjas;
import com.konoha.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


// Transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "nome")
    private String nome;


    @Column(unique = true)
    private String email;


    @Column(name = "img_url")
    private String imgUrl;


    @Column(name = "idade")
    private int idade;


    @Column(name = "rank")
    private String rank;


    // @ManyToOne - um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key (Chave Estrageira)
    private MissoesModel missoes;


}
