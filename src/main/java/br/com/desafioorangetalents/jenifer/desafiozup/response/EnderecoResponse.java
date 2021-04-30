package br.com.desafioorangetalents.jenifer.desafiozup.response;

import br.com.desafioorangetalents.jenifer.desafiozup.models.Endereco;

public class EnderecoResponse {

    private final long id;

    private final String logradouro;

    private final int numero;

    private final String complemento;

    private final String bairro;

    private final String cidade;

    private final String estado;

    private final String cep;

    public EnderecoResponse(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
    }

    //Getters
    public long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
