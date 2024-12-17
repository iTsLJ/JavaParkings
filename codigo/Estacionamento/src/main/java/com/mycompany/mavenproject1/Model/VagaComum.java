/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

import com.mycompany.mavenproject1.Model.Vaga;

/**
 *
 * @author mateu
 */
class VagaComum extends Vaga {

    public VagaComum(String idVaga, boolean status) {
        super(idVaga, status, "Comum");
    }
    private static final double TAXA = 1;

    @Override
    public double getTaxa() {
        return TAXA;
    }

    @Override
    public String getTipoDeVaga() {
        return "Comum";
    }
}
