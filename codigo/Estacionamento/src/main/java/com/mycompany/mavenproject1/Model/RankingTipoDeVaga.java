/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

/**
 *
 * @author joao
 */
public class RankingTipoDeVaga {
    private String tipoDeVaga;
    private float valorTotal;
    private int utilizacoes;

    public RankingTipoDeVaga(String tipoDeVaga, float valorTotal, int utilizacoes) {
    this.tipoDeVaga = tipoDeVaga;
    this.valorTotal = valorTotal;
    this.utilizacoes = utilizacoes;
}

    public String getTipoDeVaga() {
        return tipoDeVaga;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public int getUtilizacoes() {
        return utilizacoes;
    }
}
