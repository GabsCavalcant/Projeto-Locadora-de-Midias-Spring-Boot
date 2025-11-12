package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Cidade;
import com.locadoramidia.locadora.model.Cliente;
import com.locadoramidia.locadora.repositorio.CidadeRepositorio;
import com.locadoramidia.locadora.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para as regras de negócio de Cliente.
 */
@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private CidadeRepositorio cidadeRepositorio; // Para o dropdown do formulário

    // --- Métodos para Cliente ---
    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepositorio.findById(id);
    }

    public void excluir(Long id) {
        clienteRepositorio.deleteById(id);
    }

    // --- Métodos de Cidades (para o formulário) ---
    public List<Cidade> listarTodasCidades() {
        // Em um app real, isso poderia ser otimizado (ex: buscar por estado)
       
        return cidadeRepositorio.findAll();
    }
}