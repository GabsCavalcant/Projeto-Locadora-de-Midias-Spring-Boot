package com.locadoramidia.locadora.controle;

import com.locadoramidia.locadora.model.Locacao;
import com.locadoramidia.locadora.servico.LocacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locacoes")
public class LocacaoControle {

    @Autowired
    private LocacaoServico locacaoServico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listaLocacoes", locacaoServico.listarTodas());
        return "formularios/locacoes/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("locacao", new Locacao());
        model.addAttribute("listaClientes", locacaoServico.listarTodosClientes());
        model.addAttribute("listaExemplaresDisponiveis", locacaoServico.listarExemplaresDisponiveis());
        return "formularios/locacoes/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Locacao locacao, 
                         @RequestParam(required = false) List<String> exemplaresSelecionados) {
        
        locacaoServico.realizarLocacao(locacao, exemplaresSelecionados);
        return "redirect:/locacoes/listar";
    }

    // --- NOVA ROTA DE DEVOLUÇÃO ---
    @GetMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        locacaoServico.realizarDevolucao(id);
        return "redirect:/locacoes/listar";
    }
}