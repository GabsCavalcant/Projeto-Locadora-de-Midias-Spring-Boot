package com.locadoramidia.locadora.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
import java.time.LocalDate; // <-- 1. O import correto e moderno para datas

/**
 * Entidade Ator.
 *
 * @author gabri
 */
@Entity
@Table(name = "ator")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 1, max = 50)
    private String nome;
    
    @NotNull(message = "O sobrenome não pode ser nulo.")
    @Size(min = 1, max = 100)
    private String sobrenome;
    
    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data deve estar no passado.")
    @Column(name = "dataEstreia") // 2. Como a coluna vai se chamar no banco
    private LocalDate dataEstreia; // 3. O tipo de dado correto

    /**
     * Construtor vazio obrigatório para o JPA.
     */
    public Ator() {
    }

    // --- Getters e Setters ---

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataEstreia;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataEstreia = dataNascimento;
    }
}