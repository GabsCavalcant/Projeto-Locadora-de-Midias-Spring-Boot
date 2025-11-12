package com.locadoramidia.locadora.model; // Pacote do novo projeto Spring

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Entidade ClassificacaoInterna.
 * Adaptada para Spring Data JPA.
 */
@Entity // 1. Diz ao Spring que esta classe é uma tabela
@Table(name = "classificacao_interna") // 2. Nome da tabela (snake_case)
public class ClassificacaoInterna {

    @Id // 3. Marca como Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. O banco vai gerar o ID (Auto-Incremento)
    private Long id;
    
    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 1, max = 45, message = "A descrição deve ter entre 1 e 45 caracteres.")
    @Column(length = 45) // 5. Garante que o tamanho no banco seja 45
    private String descricao;
    
    @NotNull(message = "O valor do aluguel não pode ser nulo.")
    @PositiveOrZero(message = "O valor do aluguel não pode ser negativo.")
    @Column(name = "valor_aluguel", precision = 10, scale = 2) // 6. Essencial para dinheiro!
    private BigDecimal valorAluguel;

    
    public ClassificacaoInterna() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
}