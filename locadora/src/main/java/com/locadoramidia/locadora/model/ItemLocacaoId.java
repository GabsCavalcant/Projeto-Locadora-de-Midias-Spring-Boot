package com.locadoramidia.locadora.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


//Classe para represenetar a tabela de N:N 
@Embeddable
public class ItemLocacaoId implements Serializable {

    private Long locacaoId;
    private String exemplarCodigoInterno;

    public ItemLocacaoId() {}

    public ItemLocacaoId(Long locacaoId, String exemplarCodigoInterno) {
        this.locacaoId = locacaoId;
        this.exemplarCodigoInterno = exemplarCodigoInterno;
    }

    // Getters, Setters, Equals e HashCode (Obrigatórios para chaves compostas)
    public Long getLocacaoId() { return locacaoId; }
    public void setLocacaoId(Long locacaoId) { this.locacaoId = locacaoId; }
    public String getExemplarCodigoInterno() { return exemplarCodigoInterno; }
    public void setExemplarCodigoInterno(String exemplarCodigoInterno) { this.exemplarCodigoInterno = exemplarCodigoInterno; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemLocacaoId that = (ItemLocacaoId) o;
        return Objects.equals(locacaoId, that.locacaoId) &&
               Objects.equals(exemplarCodigoInterno, that.exemplarCodigoInterno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locacaoId, exemplarCodigoInterno);
    }
}