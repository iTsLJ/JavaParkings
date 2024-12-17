package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Veiculo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClienteTest {

    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente("João");
    }

    @Test
    public void testGetNome() {
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testSetNome() {
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    public void testGetIdentificador() {
        assertEquals(0, cliente.getIdentificador());
    }

    @Test
    public void testSetIdentificador() {
        cliente.setIdentificador(10);
        assertEquals(10, cliente.getIdentificador());
    }

    @Test
    public void testGetVeiculos() {
        assertNotNull(cliente.getVeiculos());
        assertTrue(cliente.getVeiculos().isEmpty());
    }

    @Test
    public void testSetVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Veiculo veiculo = new Veiculo("ABC1234");
        veiculos.add(veiculo);
        cliente.setVeiculos(veiculos);

        assertEquals(1, cliente.getVeiculos().size());
        assertEquals(veiculo, cliente.getVeiculos().get(0));
    }

    @Test
    public void testAddVeiculo() {
        Veiculo veiculo = new Veiculo("XYZ5678");
        cliente.getVeiculos().add(veiculo);

        assertEquals(1, cliente.getVeiculos().size());
        assertEquals(veiculo, cliente.getVeiculos().get(0));
    }
}
