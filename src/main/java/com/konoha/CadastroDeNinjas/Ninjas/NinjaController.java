package com.konoha.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (Create)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasId(@PathVariable Long id){
        return ninjaService.listarNinjasId(id);
    }

    // Alterar dados dos Ninjas (Update)
    @PutMapping("/alterar")
    public String alterarNinjaPorID(){
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/deleteID")
    public String deletarNinjaPorID(){
        return "Deletar Ninja por ID";
    }

}
