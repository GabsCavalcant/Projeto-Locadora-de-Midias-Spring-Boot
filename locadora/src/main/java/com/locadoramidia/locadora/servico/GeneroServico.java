package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Genero;
import com.locadoramidia.locadora.repositorio.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Genero.
 * Substitui o antigo GeneroService.
 */
@Service
public class GeneroServico { // <-- Nome da classe atualizado

    @Autowired // 1. O Spring "injeta" o repositório aqui automaticamente
    private GeneroRepositorio generoRepository;

    // Método para listar todos
    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    // Método para salvar (serve tanto para criar um novo quanto para atualizar um existente)
    public Genero salvar(Genero genero) {
        // (Aqui poderiam entrar regras de negócio, ex: "não salvar se descrição já existir")
        return generoRepository.save(genero);
    }

    // Método para buscar por ID
    public Optional<Genero> buscarPorId(Long id) {
        return generoRepository.findById(id);
    }

    // Método para excluir
    public void excluir(Long id) {
        generoRepository.deleteById(id);
    }
}