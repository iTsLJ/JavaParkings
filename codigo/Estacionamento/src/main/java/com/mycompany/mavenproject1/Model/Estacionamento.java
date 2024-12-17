/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author LGGENGENHARIA
 */
public class Estacionamento implements Serializable{
    
    int idEstacionamento;
    int numeroDeVagasVIP;
    int numeroDeVagasPCD;
    int numeroDeVagasIdosos;
    int numeroDeVagasComuns;
    private int vagasDisponiveis; 
    private int vagasOcupadas;
    private final String nome;
    private final List<Vaga> vagas;

    public Estacionamento(int numeroDeVagasVIP, int numeroDeVagasPCD, int numeroDeVagasIdosos, int numeroDeVagasComuns, String nome, int idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
        this.numeroDeVagasVIP = numeroDeVagasVIP;
        this.numeroDeVagasPCD = numeroDeVagasPCD;
        this.numeroDeVagasIdosos = numeroDeVagasIdosos;
        this.numeroDeVagasComuns = numeroDeVagasComuns;
        this.nome = nome;
        this.vagas = new ArrayList<>(); 
    }

    public int getIdEstacionamento() {
        return idEstacionamento;
    }

    public void setIdEstacionamento(int idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
    }
    
    
    public int getVagasOcupadas() {
        return this.vagasOcupadas;
    }
    
    public int getVagasDisponiveis() {
        return this.vagasDisponiveis; 
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public String getNome() {
        return nome;
    }
    public int getNumeroDeVagasVIP() {
    return numeroDeVagasVIP;
}

public int getNumeroDeVagasPCD() {
    return numeroDeVagasPCD;
}

public int getNumeroDeVagasIdosos() {
    return numeroDeVagasIdosos;
}

public int getNumeroDeVagasComuns() {
    return numeroDeVagasComuns;
}

    public Estacionamento getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
