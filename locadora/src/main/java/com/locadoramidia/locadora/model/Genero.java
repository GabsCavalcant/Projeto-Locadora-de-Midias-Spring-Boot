package com.locadoramidia.locadora.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.Size;



/**
 * Entidade Genero.
 *
 * @author Prof. Dr. David Buzatto
 */

@Entity
@Table(name = "genero")
public class Genero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 1, max = 45, message = "A descrição deve ter entre 1 e 45 caracteres.")
    @Column(length = 45) // 5. Garante que o tamanho no banco seja 45
    private String descricao;
    
    
    public Genero(){
        
       
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

}
