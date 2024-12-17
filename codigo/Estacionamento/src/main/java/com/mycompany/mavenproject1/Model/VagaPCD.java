package com.mycompany.mavenproject1.Model;

import com.mycompany.mavenproject1.Model.Vaga;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateu
 */
class VagaPCD extends Vaga {
    public VagaPCD(String idVaga, boolean status) {
        super(idVaga, status, "PCD");
    } 
    
    private static final double TAXA = 0.87; 
    
    @Override
    public double getTaxa() {
        return TAXA;
    }

    @Override
    public String getTipoDeVaga() {
        return "PCD";
    }
}
