package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Ator;
import com.locadoramidia.locadora.servico.AtorServico;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// ... (imports) ...

/**
 * Controller para o CRUD de Ator.
 * @author gabri
 */
@Controller
@RequestMapping("/atores")
public class AtorControle {

    @Autowired
    private AtorServico atorServico; 

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaAtores", atorServico.listarTodos());
        return "formularios/atores/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        // CORRIGIDO AQUI: de "atores" para "ator" (singular)
        model.addAttribute("ator", new Ator());
        return "formularios/atores/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid 
                         // CORRIGIDO AQUI: de "atores" para "ator" (singular)
                         @ModelAttribute("ator") Ator ator,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "formularios/atores/form";
        }
        
        atorServico.salvar(ator);
        return "redirect:/atores/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        
        Optional<Ator> ator = atorServico.buscarPorId(id);
        
        if (ator.isPresent()) {
            // CORRIGIDO AQUI: de "atores" para "ator" (singular)
            model.addAttribute("ator", ator.get());
            return "formularios/atores/form";
        }
        
        return "redirect:/atores/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        atorServico.excluir(id);
        return "redirect:/atores/listar";
    }
}