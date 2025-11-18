package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Exemplar;
import com.locadoramidia.locadora.model.Midia;
import com.locadoramidia.locadora.repositorio.ExemplarRepositorio;
import com.locadoramidia.locadora.repositorio.MidiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Exemplar.
 */
@Service
public class ExemplarServico {

    @Autowired
    private ExemplarRepositorio exemplarRepositorio;

    @Autowired
    private MidiaRepositorio midiaRepositorio; 

    // --- Métodos do CRUD de Exemplar ---

    public List<Exemplar> listarTodos() {
        return exemplarRepositorio.findAll();
    }

    public Exemplar salvar(Exemplar exemplar) {
        return exemplarRepositorio.save(exemplar);
    }

    
    public Optional<Exemplar> buscarPorId(String id) {
        return exemplarRepositorio.findById(id);
    }

    // CORRIGIDO AQUI: Recebe String id
    public void excluir(String id) {
        exemplarRepositorio.deleteById(id);
    }

    // --- Métodos para carregar o <select> (dropdown) ---

    public List<Midia> listarTodasMidias() {
        return midiaRepositorio.findAll();
    }
}