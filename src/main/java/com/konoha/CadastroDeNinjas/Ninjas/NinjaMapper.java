package com.konoha.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaDTO.getId());
        ninjaDTO.setNome(ninjaDTO.getNome());
        ninjaDTO.setEmail(ninjaDTO.getEmail());
        ninjaDTO.setIdade(ninjaDTO.getIdade());
        ninjaDTO.setImgUrl(ninjaDTO.getImgUrl());
        ninjaDTO.setRank(ninjaDTO.getRank());
        ninjaDTO.setMissoes(ninjaDTO.getMissoes());

        return ninjaDTO;

    }

}
