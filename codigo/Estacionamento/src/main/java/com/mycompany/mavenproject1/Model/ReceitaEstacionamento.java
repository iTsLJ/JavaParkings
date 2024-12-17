package com.mycompany.mavenproject1.Model;

public class ReceitaEstacionamento {

    private float totalReceita;
    private int quantidadeTiquetes;
    private float valorMedio;

    public ReceitaEstacionamento(float totalReceita, int quantidadeTiquetes) {
        this.totalReceita = totalReceita;
        this.quantidadeTiquetes = quantidadeTiquetes;
        this.valorMedio = quantidadeTiquetes > 0 ? totalReceita / quantidadeTiquetes : 0;
    }

    public float getTotalReceita() {
        return totalReceita;
    }

    public int getQuantidadeTiquetes() {
        return quantidadeTiquetes;
    }

    public float getValorMedio() {
        return valorMedio;
    }
}
