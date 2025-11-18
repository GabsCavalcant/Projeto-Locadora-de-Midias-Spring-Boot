package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Exemplar;
import com.locadoramidia.locadora.servico.ExemplarServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Exemplar.
 */
@Controller
@RequestMapping("/exemplares")
public class ExemplarControle {

    @Autowired
    private ExemplarServico exemplarServico;

    // Método auxiliar para carregar o dropdown de Mídias
    private void carregarListaDeMidias(Model model) {
        model.addAttribute("listaMidias", exemplarServico.listarTodasMidias());
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaExemplares", exemplarServico.listarTodos());
        return "formularios/exemplares/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("exemplar", new Exemplar());
        carregarListaDeMidias(model); 
        return "formularios/exemplares/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("exemplar") Exemplar exemplar,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            carregarListaDeMidias(model);
            return "formularios/exemplares/form";
        }

        exemplarServico.salvar(exemplar);
        return "redirect:/exemplares/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) { 
        Optional<Exemplar> exemplar = exemplarServico.buscarPorId(id); // Passa a String
        if (exemplar.isPresent()) {
            model.addAttribute("exemplar", exemplar.get());
            carregarListaDeMidias(model); 
            return "formularios/exemplares/form";
        }
        return "redirect:/exemplares/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable String id) { 
        exemplarServico.excluir(id);
        return "redirect:/exemplares/listar";
    }
}