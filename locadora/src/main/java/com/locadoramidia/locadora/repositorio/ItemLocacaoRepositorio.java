package com.locadoramidia.locadora.repositorio;

import com.locadoramidia.locadora.model.ItemLocacao;
import com.locadoramidia.locadora.model.ItemLocacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLocacaoRepositorio extends JpaRepository<ItemLocacao, ItemLocacaoId> {}