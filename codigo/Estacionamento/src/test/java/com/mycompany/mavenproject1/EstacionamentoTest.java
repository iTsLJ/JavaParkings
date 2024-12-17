package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.Estacionamento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;

public class EstacionamentoTest {

    private Estacionamento estacionamento;

    @Before
    public void setUp() {
        estacionamento = new Estacionamento(10, 5, 8, 15, "Estacionamento Central", 1);
    }

    @Test
    public void testGetIdEstacionamento() {
        assertEquals(1, estacionamento.getIdEstacionamento());
    }

    @Test
    public void testSetIdEstacionamento() {
        estacionamento.setIdEstacionamento(2);
        assertEquals(2, estacionamento.getIdEstacionamento());
    }

    @Test
    public void testGetNome() {
        assertEquals("Estacionamento Central", estacionamento.getNome());
    }

    @Test
    public void testGetNumeroDeVagas() {
        assertEquals(10, estacionamento.getNumeroDeVagasVIP());
        assertEquals(5, estacionamento.getNumeroDeVagasPCD());
        assertEquals(8, estacionamento.getNumeroDeVagasIdosos());
        assertEquals(15, estacionamento.getNumeroDeVagasComuns());
    }

    @Test
    public void testGetVagas() {
        List<?> vagas = estacionamento.getVagas();
        assertNotNull(vagas);
        assertTrue(vagas.isEmpty());
    }

    @Test
    public void testGetVagasOcupadas() {
        assertEquals(0, estacionamento.getVagasOcupadas());
    }

    @Test
    public void testGetVagasDisponiveis() {
        assertEquals(0, estacionamento.getVagasDisponiveis());
    }
}
