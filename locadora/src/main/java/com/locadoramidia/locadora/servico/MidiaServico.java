package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.*; // Importa todos os modelos
import com.locadoramidia.locadora.repositorio.*; // Importa todos os repositórios
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Midia.
 */
@Service
public class MidiaServico {

    @Autowired
    private MidiaRepositorio midiaRepositorio;
    
    // Injeções para os 6 dropdowns do formulário
    @Autowired
    private AtorRepositorio atorRepositorio;
    @Autowired
    private GeneroRepositorio generoRepositorio;
    @Autowired
    private TipoRepositorio tipoRepositorio;
    @Autowired
    private ClassificacaoEtariaRepositorio classificacaoEtariaRepositorio;
    @Autowired
    private ClassificacaoInternaRepositorio classificacaoInternaRepositorio;

    // --- Métodos do CRUD de Midia ---

    public List<Midia> listarTodos() {
        return midiaRepositorio.findAll();
    }

    public Midia salvar(Midia midia) {
        return midiaRepositorio.save(midia);
    }

    public Optional<Midia> buscarPorId(Long id) {
        return midiaRepositorio.findById(id);
    }

    public void excluir(Long id) {
        midiaRepositorio.deleteById(id);
    }

    // --- Métodos para carregar os <select> (dropdowns) do formulário ---

    public List<Ator> listarTodosAtores() {
        return atorRepositorio.findAll();
    }
    
    public List<Genero> listarTodosGeneros() {
        return generoRepositorio.findAll();
    }

    public List<Tipo> listarTodosTipos() {
        return tipoRepositorio.findAll();
    }

    public List<ClassificacaoEtaria> listarTodasClassificacoesEtarias() {
        return classificacaoEtariaRepositorio.findAll();
    }

    public List<ClassificacaoInterna> listarTodasClassificacoesInternas() {
        return classificacaoInternaRepositorio.findAll();
    }
}