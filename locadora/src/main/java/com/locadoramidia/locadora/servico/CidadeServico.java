package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Cidade;
import com.locadoramidia.locadora.model.Estado;
import com.locadoramidia.locadora.repositorio.CidadeRepositorio;
import com.locadoramidia.locadora.repositorio.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Cidade.
 */
@Service
public class CidadeServico {

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    @Autowired
    private EstadoRepositorio estadoRepositorio; // <- Injetamos o Repositório de Estado

    // --- Métodos para Cidade ---
    public List<Cidade> listarTodos() {
        return cidadeRepositorio.findAll();
    }

    public Cidade salvar(Cidade cidade) {
        return cidadeRepositorio.save(cidade);
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepositorio.findById(id);
    }

    public void excluir(Long id) {
        cidadeRepositorio.deleteById(id);
    }

    // --- Método para buscar Estados ---
    // Usado para popular o <select> no formulário de Cidade
    public List<Estado> listarTodosEstados() {
        return estadoRepositorio.findAll();
    }
}