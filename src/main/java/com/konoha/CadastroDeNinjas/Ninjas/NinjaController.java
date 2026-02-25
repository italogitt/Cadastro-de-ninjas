package com.konoha.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")

public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um ninja", description = "A rota permite que um usuário crie um ninja e insira-o automaticamente do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha ao criar ninja. O servidos não conseguiu processar a requisição devido à um erro do usuário.")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja '" + novoNinja.getNome() + "' criado com sucesso!");
    }



    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "A rota permite que um usuário visualize todos os ninjas presentes no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum ninja encontrado no banco de dados")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }



    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninjas especificado pelo ID", description = "A rota permite que um usuário visualize um ninjas específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado.")
    })
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
    @Operation(summary = "Altera o ninja por ID", description = "A rota permite que um usuário altere os dados de um ninjas especifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível alterar")
    })
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
    @Operation(summary = "Deletar o ninjas por ID", description = "A rota permite que um usuário delete um ninjas especifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível alterar")
    })
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
