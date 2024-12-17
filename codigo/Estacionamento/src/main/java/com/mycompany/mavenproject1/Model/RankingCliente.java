/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

/**
 *
 * @author mateu
 */
public class RankingCliente {
    private String nome;
    private float valorTotal;
    private int utilizacoes;

    public RankingCliente(String nome, float valorTotal, int utilizacoes) {
        this.nome = nome;
        this.valorTotal = valorTotal;
        this.utilizacoes = utilizacoes;
    }

    public String getNome() {
        return nome;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public int getUtilizacoes() {
        return utilizacoes;
    }
}
