/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

/**
 *
 * @author LGGENGENHARIA
 */
public class Veiculo {
    private String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca(){
        return placa;
    } 
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    @Override
    public String toString() {
        return "Veículo [Placa: " + this.placa + "]";
    }
}
