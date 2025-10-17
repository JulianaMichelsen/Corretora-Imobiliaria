package com.corretora.model;

public abstract class Imovel {
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    protected Proprietario proprietario; //

    public Imovel(String endereco, int numero, boolean alugado, Proprietario proprietario) {
        this.endereco = endereco;
        this.numero = numero;
        this.alugado = alugado;
        this.proprietario = proprietario;
    }

    public abstract String estaAlugado();

    public String contatoProprietario() {
        return "Proprietário: " + proprietario.getNome() +
                " | Telefone: " + proprietario.getTelefone();
    }

    public abstract int calcularAluguel(int meses);

    public String getEndereco() {
        return endereco;
    }


    public int getNumero() {
        return numero;
    }


    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

}
