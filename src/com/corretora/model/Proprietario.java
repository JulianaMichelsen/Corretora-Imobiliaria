package com.corretora.model;

public class Proprietario {

    private String nome;
    private String telefone;
    private String cpf;

    public Proprietario(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", CPF: " + cpf;
    }
}
