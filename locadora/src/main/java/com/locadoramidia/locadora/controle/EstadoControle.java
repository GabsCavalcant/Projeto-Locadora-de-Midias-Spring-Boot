package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Estado;
import com.locadoramidia.locadora.servico.EstadoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Estado.
 */
@Controller
@RequestMapping("/estados") // URL base para este CRUD
public class EstadoControle {

    @Autowired
    private EstadoServico estadoServico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaEstados", estadoServico.listarTodos());
        return "formularios/estados/list"; // -> /templates/formularios/estados/list.html
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("estado", new Estado());
        return "formularios/estados/form"; // -> /templates/formularios/estados/form.html
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("estado") Estado estado,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "formularios/estados/form"; // Volta para o form se tiver erro
        }

        estadoServico.salvar(estado);
        return "redirect:/estados/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Estado> estado = estadoServico.buscarPorId(id);
        if (estado.isPresent()) {
            model.addAttribute("estado", estado.get());
            return "formularios/estados/form"; // Reusa o mesmo formulário
        }
        return "redirect:/estados/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        estadoServico.excluir(id);
        return "redirect:/estados/listar";
    }
}