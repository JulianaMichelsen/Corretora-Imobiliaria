package com.corretora.model;

public class Casa extends Imovel {
    private int valorMensal;

    public Casa(String endereco, int numero, boolean alugado, Proprietario proprietario, int valorMensal) {
        super(endereco, numero, alugado, proprietario);
        this.valorMensal = valorMensal;
    }

    @Override
    public String estaAlugado() {
        return alugado ? "A casa está alugada." : "A casa está disponível.";
    }

    @Override
    public int calcularAluguel(int meses) {
        return valorMensal * meses;
    }

}
