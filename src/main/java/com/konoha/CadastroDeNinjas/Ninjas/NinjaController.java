package com.konoha.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja '" + novoNinja.getNome() + "' criado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasId(@PathVariable Long id){
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasId(id);

        if (ninjaEncontrado != null){
            return ResponseEntity.ok(ninjaEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id + " não foi encontrado.");
        }
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO nijnaAtualizado){
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        if (ninja != null){
            ninjaService.atualizarNinja(id, nijnaAtualizado);
            return ResponseEntity.ok("Ninja '" + ninja.getNome() + "' atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id + " não foi encontrado.");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        NinjaDTO ninja = ninjaService.listarNinjasId(id);

        if (ninja != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja '" + ninja.getNome() + "' deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O Ninja com o ID: " + id + " não foi encontrado.");
            }
        }

}
