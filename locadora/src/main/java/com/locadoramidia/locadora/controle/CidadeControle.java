package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Cidade;
import com.locadoramidia.locadora.servico.CidadeServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Cidade.
 */
@Controller
@RequestMapping("/cidades") // URL base
public class CidadeControle {

    @Autowired
    private CidadeServico cidadeServico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaCidades", cidadeServico.listarTodos());
        return "formularios/cidades/list"; // -> /templates/formularios/cidades/list.html
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cidade", new Cidade());
        // Carrega a lista de estados para o dropdown
        model.addAttribute("listaEstados", cidadeServico.listarTodosEstados());
        return "formularios/cidades/form"; // -> /templates/formularios/cidades/form.html
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("cidade") Cidade cidade,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            // Se der erro, precisa carregar os estados de novo para o dropdown
            model.addAttribute("listaEstados", cidadeServico.listarTodosEstados());
            return "formularios/cidades/form";
        }

        cidadeServico.salvar(cidade);
        return "redirect:/cidades/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Cidade> cidade = cidadeServico.buscarPorId(id);
        if (cidade.isPresent()) {
            model.addAttribute("cidade", cidade.get());
            // Carrega os estados para o dropdown
            model.addAttribute("listaEstados", cidadeServico.listarTodosEstados());
            return "formularios/cidades/form";
        }
        return "redirect:/cidades/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        cidadeServico.excluir(id);
        return "redirect:/cidades/listar";
    }
}