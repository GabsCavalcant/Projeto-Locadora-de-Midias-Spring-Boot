package com.locadoramidia.locadora.controle; // <-- 1. Pacote 'controle' (corrigido)

// Imports corrigidos para seus pacotes
import com.locadoramidia.locadora.model.Tipo;
import com.locadoramidia.locadora.servico.TipoServico; // <-- 2. Pacote 'servico' (corrigido)
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Tipo.
 * Substitui o antigo TiposServlet.
 * (Versão corrigida com os pacotes do seu projeto)
 */
@Controller
@RequestMapping("/tipos") // URL base para este CRUD
public class TipoControle { // <-- 3. Nome da classe 'TipoControle' (correto)

    @Autowired
    private TipoServico tipoServico; // <-- 4. Nome da classe 'TipoServico' (correto)

    /**
     * URL: /tipos/listar
     */
    @GetMapping("/listar")
    public String listarTipos(Model model) {
        model.addAttribute("listaTipos", tipoServico.listarTodos());
        return "formularios/tipos/list"; // -> /templates/formularios/tipos/list.html
    }

    /**
     * URL: /tipos/novo
     */
    @GetMapping("/novo")
    public String novoTipo(Model model) {
        model.addAttribute("tipo", new Tipo());
        return "formularios/tipos/form"; // -> /templates/formularios/tipos/form.html
    }

    /**
     * URL: /tipos/salvar (POST)
     */
    @PostMapping("/salvar")
    public String salvarTipo(@Valid @ModelAttribute("tipo") Tipo tipo,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "formularios/tipos/form"; // Volta para o form se tiver erro
        }

        tipoServico.salvar(tipo);
        return "redirect:/tipos/listar";
    }

    /**
     * URL: /tipos/editar/{id}
     */
    @GetMapping("/editar/{id}")
    public String editarTipo(@PathVariable Long id, Model model) {
        Optional<Tipo> tipo = tipoServico.buscarPorId(id);
        if (tipo.isPresent()) {
            model.addAttribute("tipo", tipo.get());
            return "formularios/tipos/form"; // Reusa o mesmo formulário
        }
        return "redirect:/tipos/listar";
    }

    /**
     * URL: /tipos/excluir/{id}
     */
    @GetMapping("/excluir/{id}")
    public String excluirTipo(@PathVariable Long id) {
        tipoServico.excluir(id);
        return "redirect:/tipos/listar";
    }
}