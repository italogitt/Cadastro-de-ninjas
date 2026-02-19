package com.konoha.CadastroDeNinjas.Missoes;
import com.konoha.CadastroDeNinjas.Ninjas.NinjaModel;
import com.konoha.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")

public class MissoesController {


    private MissoesService missoesService;


    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoesEncontradas = missoesService.ListarMissoes();
            return ResponseEntity.ok(missoesEncontradas);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<MissoesDTO> listarMissaoPorId(@PathVariable Long id){
        MissoesDTO missaoEncontrada = missoesService.ListarMissaoPorId(id);
        if(missaoEncontrada == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(missaoEncontrada);
        }
    }


    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missaoCriada =  missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão: '" + missaoCriada.getNome() + "' criada com sucesso! (ID: " + missaoCriada.getId() + ")");
    }


    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missaoAlterada =  missoesService.alterarMissao(id, missaoAtualizada);
        if (missaoAlterada != null){
            return ResponseEntity.ok(missaoAlterada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id  " + id + " não foi encontrada nos registros.");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {

        if (missoesService.ListarMissaoPorId(id) != null){
            String nomeEncontrado = missoesService.ListarMissaoPorId(id).getNome();
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok()
                    .body("Missão: '" + nomeEncontrado + "' deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o id " + id + "não foi encontrada nos registros") ;
        }

    }
}
