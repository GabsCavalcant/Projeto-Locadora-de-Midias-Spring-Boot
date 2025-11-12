package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.ClassificacaoEtaria;
import com.locadoramidia.locadora.repositorio.ClassificacaoEtariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de ClassificacaoEtaria.
 */
@Service
public class ClassificacaoEtariaServico {

    @Autowired
    private ClassificacaoEtariaRepositorio classificacaoEtariaRepositorio;

    public List<ClassificacaoEtaria> listarTodos() {
        return classificacaoEtariaRepositorio.findAll();
    }

    public ClassificacaoEtaria salvar(ClassificacaoEtaria classificacaoEtaria) {
        return classificacaoEtariaRepositorio.save(classificacaoEtaria);
    }

    public Optional<ClassificacaoEtaria> buscarPorId(Long id) {
        return classificacaoEtariaRepositorio.findById(id);
    }

    public void excluir(Long id) {
        classificacaoEtariaRepositorio.deleteById(id);
    }
}