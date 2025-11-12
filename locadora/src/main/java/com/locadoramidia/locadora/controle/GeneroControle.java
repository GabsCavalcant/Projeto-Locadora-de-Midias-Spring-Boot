package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Genero;

import com.locadoramidia.locadora.servico.GeneroServico;
import jakarta.validation.Valid; // Para validar o @NotNull, @Size
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Genero.
 * Substitui o antigo GenerosServlet.
 */
@Controller
@RequestMapping("/generos") // Todas as URLs deste controller começam com /generos
public class GeneroControle {

    @Autowired // O Spring injeta o serviço
    private GeneroServico generoService;

    /**
     * URL: /generos/listar
     * Mostra a página de listagem
     */
    @GetMapping("/listar")
    public String listarGeneros(Model model) {
        // 1. Busca todos os gêneros no serviço
        List<Genero> generos = generoService.listarTodos();
        
        // 2. "Empacota" a lista para o Thymeleaf poder usar
        model.addAttribute("listaGeneros", generos);
        
        // 3. Retorna o nome do arquivo HTML
        return "formularios/generos/list"; // -> /templates/formularios/generos/list.html
    }

    /**
     * URL: /generos/novo
     * Mostra a página de formulário para um novo gênero
     */
    @GetMapping("/novo")
    public String novoGenero(Model model) {
        // 1. Cria um objeto Genero vazio
        Genero genero = new Genero();
        
        // 2. "Empacota" o objeto para o Thymeleaf
        model.addAttribute("genero", genero);
        
        // 3. Retorna o nome do arquivo HTML
        return "formularios/generos/form"; // -> /templates/formularios/generos/form.html
    }

    /**
     * URL: /generos/salvar (via POST do formulário)
     * Salva o gênero (novo ou existente)
     */
    @PostMapping("/salvar")
    public String salvarGenero(@Valid @ModelAttribute("genero") Genero genero, 
                               BindingResult result) {
        
        // 1. Verifica se a validação (@NotNull, @Size) falhou
        if (result.hasErrors()) {
            return "formularios/generos/form"; // Volta para o formulário
        }
        
        // 2. Se estiver tudo OK, salva
        generoService.salvar(genero);
        
        // 3. Redireciona para a página de listagem
        return "redirect:/generos/listar";
    }

    /**
     * URL: /generos/editar/{id}
     * Mostra a página de formulário com os dados de um gênero existente
     */
    @GetMapping("/editar/{id}")
    public String editarGenero(@PathVariable Long id, Model model) {
        // 1. Busca o gênero pelo ID
        Optional<Genero> genero = generoService.buscarPorId(id);
        
        if (genero.isPresent()) {
            // 2. Se achou, "empacota" para o Thymeleaf
            model.addAttribute("genero", genero.get());
            return "formularios/generos/form"; // Reusa o mesmo formulário
        }
        
        // 3. Se não achou, volta para a listagem
        return "redirect:/generos/listar";
    }

    /**
     * URL: /generos/excluir/{id}
     * Exclui o gênero pelo ID
     */
    @GetMapping("/excluir/{id}")
    public String excluirGenero(@PathVariable Long id) {
        generoService.excluir(id);
        return "redirect:/generos/listar"; // Volta para a listagem
    }
}