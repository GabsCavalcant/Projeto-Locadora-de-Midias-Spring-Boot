package com.locadoramidia.locadora.repositorio;

import com.locadoramidia.locadora.model.Locacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepositorio extends JpaRepository<Locacao, Long> {
    List<Locacao> findByDataDevolucaoRealIsNull();
}