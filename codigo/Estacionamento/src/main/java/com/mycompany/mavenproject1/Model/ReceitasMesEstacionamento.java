package com.mycompany.mavenproject1.Model;

import java.time.LocalDate;

public class ReceitasMesEstacionamento {
    private int idEstacionamento;
    private LocalDate data;
    private float totalReceita;

    public ReceitasMesEstacionamento(int idEstacionamento, LocalDate data, float totalReceita) {
        this.idEstacionamento = idEstacionamento;
        this.data = data;
        this.totalReceita = totalReceita;
    }

    public int getIdEstacionamento() {
        return idEstacionamento;
    }

    public LocalDate getData() {
        return data;
    }

    public float getTotalReceita() {
        return totalReceita;
    }
}