package com.konoha.CadastroDeNinjas.Ninjas;
import com.konoha.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar todos os ninjas por ID
    public NinjaModel listarNinjasId(Long id){
        Optional<NinjaModel> ninjaModelOptional = ninjaRepository.findById(id);
        return ninjaModelOptional.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar um ninja por ID
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }




}
