package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Estado;
import com.locadoramidia.locadora.repositorio.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Estado.
 */
@Service
public class EstadoServico {

    @Autowired
    private EstadoRepositorio estadoRepositorio;

    public List<Estado> listarTodos() {
        return estadoRepositorio.findAll();
    }

    public Estado salvar(Estado estado) {
        return estadoRepositorio.save(estado);
    }

    public Optional<Estado> buscarPorId(Long id) {
        return estadoRepositorio.findById(id);
    }

    public void excluir(Long id) {
        estadoRepositorio.deleteById(id);
    }
}