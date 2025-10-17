package com.corretora.model;

public class Apartamento extends Imovel {
    private final int valorMensal;

    public Apartamento(String endereco, int numero, boolean alugado, Proprietario proprietario, int valorMensal) {
        super(endereco, numero, alugado, proprietario);
        this.valorMensal = valorMensal;
    }

    @Override
    public String estaAlugado() {
        return alugado ? "O apartamento de número " + numero + " está alugado."
                : "O apartamento de número " + numero + " está disponível.";
    }

    @Override
    public int calcularAluguel(int meses) {
        return valorMensal * meses;
    }

}
