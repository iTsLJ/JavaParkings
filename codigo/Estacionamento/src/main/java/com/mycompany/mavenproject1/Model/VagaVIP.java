    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Model;

/**
 *
 * @author mateu
 */
class VagaVIP extends Vaga {
    public VagaVIP(String idVaga, boolean status) {
        super(idVaga, status, "VIP");
    }
    private static final double TAXA = 1.20; 

    @Override
     public double getTaxa() {
        return TAXA;
    }

    @Override
    public String getTipoDeVaga() {
        return "VIP";
    }
}
