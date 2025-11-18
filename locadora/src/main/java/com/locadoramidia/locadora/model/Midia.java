package com.locadoramidia.locadora.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidade Midia.
 * (Versão CORRIGIDA com os @JoinColumn corretos)
 */
@Entity
@Table(name = "midia")
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O título não pode ser nulo.")
    @Size(min = 1, max = 100, message = "O título deve ter entre 1 e 100 caracteres.")
    private String titulo;

    @NotNull(message = "O ano de lançamento não pode ser nulo.")
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @NotNull(message = "O código de barras não pode ser nulo.")
    @Size(min = 1, max = 45)
    @Column(name = "codigo_barras")
    private String codigoBarras;

    @NotNull(message = "A duração não pode ser nula.")
    @Min(value = 1, message = "A duração deve ser de pelo menos 1 minuto.")
    @Column(name = "duracao_em_minutos")
    private Integer duracaoEmMinutos;

    // --- Relacionamentos (Chaves Estrangeiras) ---
    
    @NotNull(message = "O Ator Principal é obrigatório.")
    @ManyToOne 
    @JoinColumn(name = "ator_principal") 
    private Ator atorPrincipal;

   
    @ManyToOne
    @JoinColumn(name = "ator_coadjuvante") 
    private Ator atorCoadjuvante; 

    
    @NotNull(message = "O Gênero é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    
    @NotNull(message = "A Classificação Etária é obrigatória.")
    @ManyToOne
    @JoinColumn(name = "classificacao_etaria_id")
    private ClassificacaoEtaria classificacaoEtaria;

    
    @NotNull(message = "O Tipo é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    
    @NotNull(message = "A Classificação Interna é obrigatória.")
    @ManyToOne
    @JoinColumn(name = "classificacao_interna_id")
    private ClassificacaoInterna classificacaoInterna;

    /**
     * Construtor vazio obrigatório para o JPA.
     */
    public Midia() {
    }

    // --- Getters e Setters ---
    // (O resto do arquivo é igual ao que você já tem)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public Ator getAtorCoadjuvante() {
        return atorCoadjuvante;
    }

    public void setAtorCoadjuvante(Ator atorCoadjuvante) {
        this.atorCoadjuvante = atorCoadjuvante;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ClassificacaoEtaria getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(ClassificacaoEtaria classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ClassificacaoInterna getClassificacaoInterna() {
        return classificacaoInterna;
    }

    public void setClassificacaoInterna(ClassificacaoInterna classificacaoInterna) {
        this.classificacaoInterna = classificacaoInterna;
    }
        
}