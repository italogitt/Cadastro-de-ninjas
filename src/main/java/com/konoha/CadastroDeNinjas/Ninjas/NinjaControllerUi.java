package com.konoha.CadastroDeNinjas.Ninjas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", listaDeNinjas);
        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String mostrarDetalhes(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        model.addAttribute("ninja", ninja);
        return "detalhesNinja";
    }

    @PostMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, NinjaDTO ninjaDTO){
        ninjaService.atualizarNinja(id, ninjaDTO);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "criarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(NinjaDTO ninjaDTO){
        ninjaService.criarNinja(ninjaDTO);
        return "redirect:/ninjas/ui/listar";
    }

}
