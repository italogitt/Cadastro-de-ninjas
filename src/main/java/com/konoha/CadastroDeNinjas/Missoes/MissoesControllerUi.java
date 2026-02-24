package com.konoha.CadastroDeNinjas.Missoes;

import com.konoha.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")

public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> listaDeMissoes = missoesService.ListarMissoes();
        model.addAttribute("missoes", listaDeMissoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
        return "redirect:/missoes/ui/listar";
    }

    @PostMapping("/alterar/{id}")
    public String alterarMissao(@PathVariable Long id, MissoesDTO missoesDTO){
        missoesService.alterarMissao(id, missoesDTO);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoMissoes(Model model){
        model.addAttribute("misses", new MissoesDTO());
        return "criarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(MissoesDTO missao){
        missoesService.criarMissao(missao);
        return "redirect:/missoes/ui/listar";
    }

}
