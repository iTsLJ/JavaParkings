/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.Veiculo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author nanda
 */
public class VeiculoTest {
    private Veiculo veiculo;

    @Before
    public void setUp() {
        veiculo = new Veiculo("ABC1234");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("ABC1234", veiculo.getPlaca());
    }

    @Test
    public void testSetPlaca() {
        veiculo.setPlaca("XYZ5678");
        assertEquals("XYZ5678", veiculo.getPlaca());
    }

    @Test
    public void testToString() {
        String expected = "Veículo [Placa: ABC1234]";
        assertEquals(expected, veiculo.toString());
    }
}
