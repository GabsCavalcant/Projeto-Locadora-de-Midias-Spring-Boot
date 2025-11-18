/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.Ator;
import com.locadoramidia.locadora.repositorio.AtorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabri
 */

@Service
public class AtorServico {
    
    @Autowired
    private AtorRepositorio atorRepositorio;
    
    public List<Ator> listarTodos(){
        return atorRepositorio.findAll();
    }
    
    public void excluir(Long id){
       atorRepositorio.deleteById(id);
    }
    
    public Ator salvar(Ator ator){
        
       return atorRepositorio.save(ator);
    }
    
    public Optional<Ator> buscarPorId(Long id){
        return atorRepositorio.findById(id);
    }
    
}
