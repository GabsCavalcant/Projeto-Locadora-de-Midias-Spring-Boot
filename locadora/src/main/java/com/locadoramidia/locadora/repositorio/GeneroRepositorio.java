package com.locadoramidia.locadora.repositorio;

import com.locadoramidia.locadora.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Genero.
 * Substitui o antigo GeneroDAO.
 * JpaRepository<TipoDaEntidade, TipoDoID>
 */
@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Long> {
    
}