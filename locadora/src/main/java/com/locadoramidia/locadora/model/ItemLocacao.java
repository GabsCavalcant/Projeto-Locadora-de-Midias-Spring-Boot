package com.locadoramidia.locadora.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_locacao")
public class ItemLocacao {

    @EmbeddedId
    private ItemLocacaoId id;

    @ManyToOne
    @MapsId("locacaoId") // Vincula com a parte da chave
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;

    @ManyToOne
    @MapsId("exemplarCodigoInterno") // Vincula com a parte da chave
    @JoinColumn(name = "exemplar_codigo_interno", referencedColumnName = "codigo_interno")
    private Exemplar exemplar;

    private BigDecimal valor;

    public ItemLocacao() {}

    // Getters e Setters
    public ItemLocacaoId getId() { return id; }
    public void setId(ItemLocacaoId id) { this.id = id; }
    public Locacao getLocacao() { return locacao; }
    public void setLocacao(Locacao locacao) { this.locacao = locacao; }
    public Exemplar getExemplar() { return exemplar; }
    public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}