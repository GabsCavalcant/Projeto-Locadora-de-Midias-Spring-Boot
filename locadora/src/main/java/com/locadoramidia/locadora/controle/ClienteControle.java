package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Cliente;
import com.locadoramidia.locadora.servico.ClienteServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller para o CRUD de Cliente.
 */
@Controller
@RequestMapping("/clientes") // URL base
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaClientes", clienteServico.listarTodos());
        return "formularios/clientes/list"; // -> /templates/formularios/clientes/list.html
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        // Carrega a lista de cidades para o dropdown
        model.addAttribute("listaCidades", clienteServico.listarTodasCidades());
        return "formularios/clientes/form"; // -> /templates/formularios/clientes/form.html
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("cliente") Cliente cliente,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            // Se der erro, precisa carregar as cidades de novo para o dropdown
            model.addAttribute("listaCidades", clienteServico.listarTodasCidades());
            return "formularios/clientes/form";
        }

        clienteServico.salvar(cliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteServico.buscarPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            // Carrega as cidades para o dropdown
            model.addAttribute("listaCidades", clienteServico.listarTodasCidades());
            return "formularios/clientes/form";
        }
        return "redirect:/clientes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        clienteServico.excluir(id);
        return "redirect:/clientes/listar";
    }
}