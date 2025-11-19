package com.locadoramidia.locadora.servico;

import com.locadoramidia.locadora.model.*;
import com.locadoramidia.locadora.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoServico {

    @Autowired private LocacaoRepositorio locacaoRepositorio;
    @Autowired private ItemLocacaoRepositorio itemLocacaoRepositorio;
    @Autowired private ExemplarRepositorio exemplarRepositorio;
    @Autowired private ClienteRepositorio clienteRepositorio;

    // --- MUDANÇA AQUI: Só lista os que não foram devolvidos ---
    public List<Locacao> listarTodas() {
        return locacaoRepositorio.findByDataDevolucaoRealIsNull();
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepositorio.findAll();
    }

    public List<Exemplar> listarExemplaresDisponiveis() {
        List<Exemplar> todos = exemplarRepositorio.findAll();
        List<Exemplar> disponiveis = new ArrayList<>();
        for (Exemplar ex : todos) {
            if (ex.isDisponivel()) {
                disponiveis.add(ex);
            }
        }
        return disponiveis;
    }

    @Transactional
    public void realizarLocacao(Locacao locacao, List<String> codigosExemplares) { // Mudou para String para bater com o Exemplar.java novo
        locacao.setDataInicio(LocalDate.now());
        locacao.setDataFim(LocalDate.now().plusDays(3)); 
        locacao.setCancelada(false);
        locacao.setDataDevolucaoReal(null);
        
        locacao = locacaoRepositorio.save(locacao);

        if (codigosExemplares != null) {
            for (String codigo : codigosExemplares) {
                Optional<Exemplar> exOpt = exemplarRepositorio.findById(codigo);
                if (exOpt.isPresent()) {
                    Exemplar exemplar = exOpt.get();

                    ItemLocacao item = new ItemLocacao();
                    // Cria chave composta
                    ItemLocacaoId id = new ItemLocacaoId();
                    id.setLocacaoId(locacao.getId());
                    id.setExemplarCodigoInterno(exemplar.getCodigoInterno());
                    item.setId(id);

                    item.setLocacao(locacao);
                    item.setExemplar(exemplar);
                    
                    if (exemplar.getMidia() != null && 
                        exemplar.getMidia().getClassificacaoInterna() != null) {
                        BigDecimal valor = exemplar.getMidia().getClassificacaoInterna().getValorAluguel();
                        item.setValor(valor); 
                    } else {
                         item.setValor(BigDecimal.ZERO);
                    }

                    itemLocacaoRepositorio.save(item);

                    exemplar.setDisponivel(false);
                    exemplarRepositorio.save(exemplar);
                }
            }
        }
    }

    @Transactional
    public void realizarDevolucao(Long idLocacao) {
        Optional<Locacao> locacaoOpt = locacaoRepositorio.findById(idLocacao);
        
        if (locacaoOpt.isPresent()) {
            Locacao locacao = locacaoOpt.get();
            
            // Devolve os exemplares
            for (ItemLocacao item : locacao.getItens()) {
                Exemplar exemplar = item.getExemplar();
                exemplar.setDisponivel(true);
                exemplarRepositorio.save(exemplar);
            }
            
            // Marca a data de devolução (isso faz sair da lista)
            locacao.setDataDevolucaoReal(LocalDate.now());
            locacaoRepositorio.save(locacao);
        }
    }
}