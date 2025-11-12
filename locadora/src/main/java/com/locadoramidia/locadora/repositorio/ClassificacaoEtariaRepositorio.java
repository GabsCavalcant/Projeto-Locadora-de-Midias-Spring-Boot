/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.locadoramidia.locadora.repositorio;

import com.locadoramidia.locadora.model.ClassificacaoEtaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author gabri
 */
@Repository
public interface ClassificacaoEtariaRepositorio extends JpaRepository<ClassificacaoEtaria, Long>{
    
}
