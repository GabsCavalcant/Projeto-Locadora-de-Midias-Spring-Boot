package com.locadoramidia.locadora.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade Exemplar (uma cópia física de uma Mídia).
 * (Versão corrigida usando codigoInterno como @Id)
 */
@Entity
@Table(name = "exemplar")
public class Exemplar {

    @Id // <-- 1. A Chave Primária é o código_interno
    @NotNull(message = "O código interno é obrigatório.")
    @Size(min = 1, max = 45, message = "O código deve ter até 45 caracteres.")
    @Column(name = "codigo_interno")
    private String codigoInterno; 

    @NotNull(message = "O status 'disponível' é obrigatório.")
    private boolean disponivel;

    @NotNull(message = "A mídia é obrigatória.")
    @ManyToOne
    @JoinColumn(name = "midia_id")
    private Midia midia;

    /**
     * Construtor vazio obrigatório para o JPA.
     */
    public Exemplar() {
    }

    // --- Getters e Setters ---

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }
}