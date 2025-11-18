package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Midia;
import com.locadoramidia.locadora.servico.MidiaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Midia.
 */
@Controller
@RequestMapping("/midias")
public class MidiaControle {

    @Autowired
    private MidiaServico midiaServico;

    // Método auxiliar para carregar os dados dos dropdowns
    private void carregarListasParaOFormulario(Model model) {
        model.addAttribute("listaAtores", midiaServico.listarTodosAtores());
        model.addAttribute("listaGeneros", midiaServico.listarTodosGeneros());
        model.addAttribute("listaTipos", midiaServico.listarTodosTipos());
        model.addAttribute("listaClassificacoesEtarias", midiaServico.listarTodasClassificacoesEtarias());
        model.addAttribute("listaClassificacoesInternas", midiaServico.listarTodasClassificacoesInternas());
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaMidias", midiaServico.listarTodos());
        return "formularios/midias/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("midia", new Midia());
        carregarListasParaOFormulario(model); // Carrega os 6 dropdowns
        return "formularios/midias/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("midia") Midia midia,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            // Se der erro, precisa carregar os dropdowns de novo
            carregarListasParaOFormulario(model);
            return "formularios/midias/form";
        }

        midiaServico.salvar(midia);
        return "redirect:/midias/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Midia> midia = midiaServico.buscarPorId(id);
        if (midia.isPresent()) {
            model.addAttribute("midia", midia.get());
            carregarListasParaOFormulario(model); // Carrega os 6 dropdowns
            return "formularios/midias/form";
        }
        return "redirect:/midias/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        midiaServico.excluir(id);
        return "redirect:/midias/listar";
    }
}