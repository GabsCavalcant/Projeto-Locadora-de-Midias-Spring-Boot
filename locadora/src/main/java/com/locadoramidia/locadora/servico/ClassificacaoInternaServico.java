package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.ClassificacaoInterna;
import com.locadoramidia.locadora.repositorio.ClassificacaoInternaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de ClassificacaoInterna.
 */
@Service
public class ClassificacaoInternaServico {

    @Autowired
    private ClassificacaoInternaRepositorio classificacaoInternaRepositorio;

    public List<ClassificacaoInterna> listarTodos() {
        return classificacaoInternaRepositorio.findAll();
    }

    public ClassificacaoInterna salvar(ClassificacaoInterna classificacaoInterna) {
        return classificacaoInternaRepositorio.save(classificacaoInterna);
    }

    public Optional<ClassificacaoInterna> buscarPorId(Long id) {
        return classificacaoInternaRepositorio.findById(id);
    }

    public void excluir(Long id) {
        classificacaoInternaRepositorio.deleteById(id);
    }
}