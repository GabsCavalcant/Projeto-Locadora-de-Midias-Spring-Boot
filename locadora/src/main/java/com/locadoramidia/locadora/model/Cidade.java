package com.locadoramidia.locadora.model; // Pacote do novo projeto Spring

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade Cidade.
 * Adaptada para Spring Data JPA.
 */
@Entity // 1. Diz ao Spring que esta classe é uma tabela no banco
@Table(name = "cidade") // 2. Nome exato da tabela no banco
public class Cidade {

    @Id // 3. Marca este campo como a Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Diz ao banco para gerar o valor (Auto-Incremento)
    private Long id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 1, max = 30, message = "O nome deve ter entre 1 e 30 caracteres.")
    private String nome;
    
    @NotNull(message = "O estado não pode ser nulo.")
    @ManyToOne // 5. Define o relacionamento: Muitas Cidades para UM Estado
    @JoinColumn(name = "estado_id") // 6. Nome da coluna da chave estrangeira no banco
    private Estado estado;

    
    public Cidade() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}