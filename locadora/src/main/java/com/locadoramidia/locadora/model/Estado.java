package com.locadoramidia.locadora.model; // Pacote do novo projeto Spring

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade Estado.
 * Adaptada para Spring Data JPA.
 */
@Entity // 1. Diz ao Spring que esta classe é uma tabela
@Table(name = "estado") // 2. Nome da tabela no banco
public class Estado {

    @Id // 3. Marca como Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. O banco vai gerar o ID (Auto-Incremento)
    private Long id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 1, max = 30, message = "O nome deve ter entre 1 e 30 caracteres.")
    private String nome;
    
    @NotNull(message = "A sigla não pode ser nula.")
    @Size(min = 1, max = 2, message = "A sigla deve ter 1 ou 2 caracteres.")
    @Column(length = 2) // 5. Boa prática: define o tamanho da coluna no banco
    private String sigla;

    
    public Estado() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}