/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Cliente implements Serializable {

    private String nome;
    private int idCliente;
    private ArrayList<Veiculo> veiculos;

    public Cliente(String nome) {
        this.nome = nome;
        this.idCliente = 0;
        this.veiculos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificador() {
        return idCliente;
    }

    public void setIdentificador(int identificador) {
        this.idCliente = identificador; 
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
