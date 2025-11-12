package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.ClassificacaoEtaria;
import com.locadoramidia.locadora.servico.ClassificacaoEtariaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Classificação Etária.
 */
@Controller
@RequestMapping("/classificacoesetarias") // URL base para este CRUD
public class ClassificacaoEtariaControle {

    @Autowired
    private ClassificacaoEtariaServico classificacaoEtariaServico;

    /**
     * URL: /classificacoesetarias/listar
     */
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaClassificacoes", classificacaoEtariaServico.listarTodos());
        return "formularios/classificacaoEtarias/list"; // -> /templates/formularios/classificacoesetarias/list.html
    }

    /**
     * URL: /classificacoesetarias/novo
     */
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("classificacao", new ClassificacaoEtaria());
        return "formularios/classificacaoEtarias/form"; // -> /templates/formularios/classificacoesetarias/form.html
    }

    /**
     * URL: /classificacoesetarias/salvar (POST)
     */
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("classificacao") ClassificacaoEtaria classificacao,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "formularios/classificacaoEtarias/form"; // Volta para o form se tiver erro
        }

        classificacaoEtariaServico.salvar(classificacao);
        return "redirect:/classificacoesetarias/listar";
    }

    /**
     * URL: /classificacoesetarias/editar/{id}
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<ClassificacaoEtaria> classificacao = classificacaoEtariaServico.buscarPorId(id);
        if (classificacao.isPresent()) {
            model.addAttribute("classificacao", classificacao.get());
            return "formularios/classificacaoEtarias/form"; // Reusa o mesmo formulário
        }
        return "redirect:/classificacoesetarias/listar";
    }

    /**
     * URL: /classificacoesetarias/excluir/{id}
     */
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        classificacaoEtariaServico.excluir(id);
        return "redirect:/classificacoesetarias/listar";
    }
}