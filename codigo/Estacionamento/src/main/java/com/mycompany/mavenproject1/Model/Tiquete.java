package com.mycompany.mavenproject1.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tiquete {

    private int codigo;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vaga vaga;
    private String tipoDeVaga;
    private LocalTime horarioDeEntrada;
    private LocalDate data;
    private boolean status;

   
    public Tiquete(Veiculo veiculo, Cliente cliente, Vaga vaga, String tipoDeVaga) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vaga = vaga;
        this.tipoDeVaga = tipoDeVaga;
        this.horarioDeEntrada = LocalTime.now();
        this.status=true;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public String getTipoDeVaga() {
        return tipoDeVaga;
    }

    public void setTipoDeVaga(String tipoDeVaga) {
        this.tipoDeVaga = tipoDeVaga;
    }

    public LocalTime getHorarioDeEntrada() {
        return horarioDeEntrada;
    }

    public void setHorarioDeEntrada(LocalTime horarioDeEntrada) {
        this.horarioDeEntrada = horarioDeEntrada;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
    
}
