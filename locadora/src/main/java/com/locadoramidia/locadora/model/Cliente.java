package com.locadoramidia.locadora.model; // Pacote do novo projeto Spring

// Imports do JPA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Import moderno para Datas
import java.time.LocalDate; 

/**
 * Entidade Cliente.
 * Adaptada para Spring Data JPA.
 */
@Entity // 1. Diz ao Spring que esta classe é uma tabela
@Table(name = "cliente") // 2. Nome da tabela no banco
public class Cliente {

    @Id // 3. Marca como Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. O banco vai gerar o ID (Auto-Incremento)
    private Long id;
    
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 1, max = 45, message = "O nome deve ter entre 1 e 45 caracteres.")
    @Column(length = 45)
    private String nome;
    
    @NotNull(message = "O sobrenome não pode ser nulo.")
    @Size(min = 1, max = 45, message = "O sobrenome deve ter entre 1 e 45 caracteres.")
    @Column(length = 45)
    private String sobrenome;
    
    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Column(name = "data_nascimento") // 5. Mapeia para coluna snake_case
    private LocalDate dataNascimento; // 6. Usei LocalDate (moderno) em vez de java.sql.Date
    
    @NotNull(message = "O CPF não pode ser nulo.")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$",
             message = "CPF deve corresponder ao formato 999.999.999-99")
    @Column(unique = true, length = 14) // 7. CPF deve ser único e ter tamanho 14
    private String cpf;
    
    @NotNull(message = "O e-mail não pode ser nulo.")
    @Email(message = "Formato de e-mail inválido.")
    @Size(min = 3, max = 60)
    @Column(unique = true, length = 60) // 8. E-mail também deve ser único
    private String email;
    
    @NotNull(message = "O logradouro não pode ser nulo.")
    @Size(min = 1, max = 50)
    @Column(length = 50)
    private String logradouro;
    
    @NotNull(message = "O número não pode ser nulo.")
    @Size(min = 1, max = 6)
    @Column(length = 6)
    private String numero;
    
    @NotNull(message = "O bairro não pode ser nulo.")
    @Size(min = 1, max = 30)
    @Column(length = 30)
    private String bairro;
    
    @NotNull(message = "O CEP não pode ser nulo.")
    @Pattern(regexp = "^\\d{5}\\-\\d{3}$",
             message = "CEP deve corresponder ao formato 99999-999")
    @Column(length = 9) // 9. Tamanho do CEP formatado
    private String cep;
    
    @NotNull(message = "A cidade não pode ser nula.")
    @ManyToOne // 10. Relacionamento: Muitos Clientes para UMA Cidade
    @JoinColumn(name = "cidade_id") // 11. Chave estrangeira no banco
    private Cidade cidade;

    public Cliente() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}