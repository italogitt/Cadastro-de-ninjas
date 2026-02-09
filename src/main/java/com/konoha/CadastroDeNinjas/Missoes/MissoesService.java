package com.konoha.CadastroDeNinjas.Missoes;

import com.konoha.CadastroDeNinjas.Ninjas.NinjaModel;
import com.konoha.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Lembrar de declarar com service
public class MissoesService {

    //Configs basicas
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }


    //Listar
    public List<MissoesModel> ListarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar por Id
    public MissoesModel ListarMissaoPorId(Long id){
        Optional<MissoesModel> missoesModelOptional = missoesRepository.findById(id);
        return missoesModelOptional.orElse(null);
    }

    //Criar
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Delete
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

}
