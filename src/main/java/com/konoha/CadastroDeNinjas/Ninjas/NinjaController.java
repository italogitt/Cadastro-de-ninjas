package com.konoha.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/all")
    public String mostrarTodosOsNinjas(){
        return "Mostrar todos os ninjas";
    }

    // Mostrar Ninja por ID (Create)
    @GetMapping("/allID")
    public String mostrarTodosOsNinjasPorID(){
        return "Mostrar todos os IDs ninjas";
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
