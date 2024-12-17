package com.mycompany.mavenproject1;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Vaga;
import com.mycompany.mavenproject1.Model.Tiquete;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TiqueteTest {

    private Tiquete tiquete;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vaga vaga;

    @Before
    public void setUp() {
        veiculo = new Veiculo("ABC1234");
        cliente = new Cliente("João");
        vaga = new Vaga("001", false, "VIP"); // Construtor corrigido
        tiquete = new Tiquete(veiculo, cliente, vaga, "VIP");
    }

    @Test
    public void testGetVeiculo() {
        assertEquals(veiculo, tiquete.getVeiculo());
    }

    @Test
    public void testSetVeiculo() {
        Veiculo novoVeiculo = new Veiculo("XYZ5678");
        tiquete.setVeiculo(novoVeiculo);
        assertEquals(novoVeiculo, tiquete.getVeiculo());
    }

    @Test
    public void testGetCliente() {
        assertEquals(cliente, tiquete.getCliente());
    }

    @Test
    public void testSetCliente() {
        Cliente novoCliente = new Cliente("Maria");
        tiquete.setCliente(novoCliente);
        assertEquals(novoCliente, tiquete.getCliente());
    }

    @Test
    public void testGetVaga() {
        assertEquals(vaga, tiquete.getVaga());
    }

    @Test
    public void testSetVaga() {
        Vaga novaVaga = new Vaga("002", false, "COMUM");
        tiquete.setVaga(novaVaga);
        assertEquals(novaVaga, tiquete.getVaga());
    }

    @Test
    public void testGetTipoDeVaga() {
        assertEquals("VIP", tiquete.getTipoDeVaga());
    }

    @Test
    public void testSetTipoDeVaga() {
        tiquete.setTipoDeVaga("PCD");
        assertEquals("PCD", tiquete.getTipoDeVaga());
    }

    @Test
    public void testGetHorarioDeEntrada() {
        LocalTime horarioDeEntrada = tiquete.getHorarioDeEntrada();
        assertNotNull(horarioDeEntrada);
        assertTrue(horarioDeEntrada.isBefore(LocalTime.now()) || horarioDeEntrada.equals(LocalTime.now()));
    }

    @Test
    public void testSetHorarioDeEntrada() {
        LocalTime novoHorario = LocalTime.of(10, 0);
        tiquete.setHorarioDeEntrada(novoHorario);
        assertEquals(novoHorario, tiquete.getHorarioDeEntrada());
    }

    @Test
    public void testGetData() {
        assertNull(tiquete.getData());
    }

    @Test
    public void testSetData() {
        LocalDate novaData = LocalDate.of(2024, 12, 9);
        tiquete.setData(novaData);
        assertEquals(novaData, tiquete.getData());
    }

    @Test
    public void testGetCodigo() {
        assertEquals(0, tiquete.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        tiquete.setCodigo(123);
        assertEquals(123, tiquete.getCodigo());
    }

    @Test
    public void testIsStatus() {
        assertTrue(tiquete.isStatus());
    }

    @Test
    public void testSetStatus() {
        tiquete.setStatus(false);
        assertFalse(tiquete.isStatus());
    }
}
