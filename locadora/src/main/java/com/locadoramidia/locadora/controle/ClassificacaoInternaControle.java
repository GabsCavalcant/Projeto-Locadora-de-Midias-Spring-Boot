package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.ClassificacaoInterna;
import com.locadoramidia.locadora.servico.ClassificacaoInternaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Classificação Interna.
 */
@Controller
@RequestMapping("/classificacoesinternas") // URL base
public class ClassificacaoInternaControle {

    @Autowired
    private ClassificacaoInternaServico classificacaoInternaServico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaClassificacoes", classificacaoInternaServico.listarTodos());
        return "formularios/classificacaoInternas/list"; // -> /templates/formularios/classificacoesinternas/list.html
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("classificacao", new ClassificacaoInterna());
        return "formularios/classificacaoInternas/form"; // -> /templates/formularios/classificacoesinternas/form.html
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("classificacao") ClassificacaoInterna classificacao,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "formularios/classificacaoInternas/form";
        }

        classificacaoInternaServico.salvar(classificacao);
        return "redirect:/classificacoesinternas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<ClassificacaoInterna> classificacao = classificacaoInternaServico.buscarPorId(id);
        if (classificacao.isPresent()) {
            model.addAttribute("classificacao", classificacao.get());
            return "formularios/classificacaoInternas/form";
        }
        return "redirect:/classificacoesinternas/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        classificacaoInternaServico.excluir(id);
        return "redirect:/classificacoesinternas/listar";
    }
}