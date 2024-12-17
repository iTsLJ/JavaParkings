/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

/**
 *
 * @author LGGENGENHARIA
 */
public class Vaga {

    private final String idVaga;
    private boolean status;
    private final String tipo;

    public Vaga(String idVaga, boolean status, String tipo) {
        this.idVaga = idVaga;
        this.status = status;
        this.tipo = tipo;
    }

    public boolean alterarStatus() {
        this.status = !this.status;
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getIdVaga() {
        return idVaga;
    }

    public String getTipoDeVaga() {
        return tipo;
    }

    // Método estático para criar a vaga com base no tipo
    public static Vaga criarVaga(String id, boolean ocupada, String tipo) {
        switch (tipo.toUpperCase()) { 
            case "VIP":
                return new VagaVIP(id, ocupada);
            case "PCD":
                return new VagaPCD(id, ocupada);
            case "IDOSOS":
                return new VagaIdoso(id, ocupada);
            case "COMUM":
                return new VagaComum(id, ocupada);
            default:
                throw new IllegalArgumentException("Tipo de vaga inválido: " + tipo);
        }
    }

    @Override
    public String toString() {
        return "ID da Vaga: " + idVaga + " | Tipo: " + getTipoDeVaga() + " | Ocupada: " + (status ? "Sim" : "Não");
    }

    public double getTaxa() {
        double TAXA = 0;
        return TAXA;
    }
}
