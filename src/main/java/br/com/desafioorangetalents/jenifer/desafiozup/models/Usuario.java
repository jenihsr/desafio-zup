package br.com.desafioorangetalents.jenifer.desafiozup.models;

import br.com.desafioorangetalents.jenifer.desafiozup.controllers.EnderecoController;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    @Email(message = "Esse campo é obrigatório, digite um e-mail válido.")
    private String email;

    @Column(unique = true)
    @CPF(message = "Esse campo é obrigatório, digite um CPF válido.")
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    //@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    //private List<Endereco> enderecos = new LinkedList<>();


    // Construtor vazio
    @Deprecated
    public Usuario(){

    }
    // Construtor
    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    // Getters
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}


