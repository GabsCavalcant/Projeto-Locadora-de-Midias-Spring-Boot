package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Tipo;
import com.locadoramidia.locadora.repositorio.TipoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Tipo.
 */
@Service
public class TipoServico {

    @Autowired
    private TipoRepositorio tipoRepository;

    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }

    public Tipo salvar(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public Optional<Tipo> buscarPorId(Long id) {
        return tipoRepository.findById(id);
    }

    public void excluir(Long id) {
        tipoRepository.deleteById(id);
    }
}