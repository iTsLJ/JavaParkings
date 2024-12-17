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
class VagaIdoso extends Vaga {
    private static final double TAXA = 0.85;

    public VagaIdoso(String idVaga, boolean status) {
        super(idVaga, status, "Idoso");
    }

    @Override
    public double getTaxa() {
        return TAXA;
    }

    @Override
    public String getTipoDeVaga() {
        return "Idoso";
    }
}
