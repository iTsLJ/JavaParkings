package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.Vaga;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VagaTest {

    private Vaga vaga;

    @Before
    public void setUp() {
        vaga = new Vaga("001", false, "VIP");
    }

    @Test
    public void testGetIdVaga() {
        assertEquals("001", vaga.getIdVaga());
    }

    @Test
    public void testGetTipoDeVaga() {
        assertEquals("VIP", vaga.getTipoDeVaga());
    }

    @Test
    public void testIsStatus() {
        assertFalse(vaga.isStatus()); // A vaga deve começar desocupada
    }

    @Test
    public void testAlterarStatus() {
        boolean novoStatus = vaga.alterarStatus();
        assertTrue(novoStatus); // O status deve ser alterado para ocupado
        assertTrue(vaga.isStatus()); // Verificar novamente se o status foi atualizado
    }

    @Test
    public void testSetStatus() {
        vaga.setStatus(true);
        assertTrue(vaga.isStatus());
    }

    @Test
    public void testToString() {
        String esperado = "ID da Vaga: 001 | Tipo: VIP | Ocupada: Não";
        assertEquals(esperado, vaga.toString());
    }

    @Test
    public void testCriarVaga() {
        Vaga vagaVIP = Vaga.criarVaga("002", true, "VIP");
        assertEquals("002", vagaVIP.getIdVaga());
        assertEquals("VIP", vagaVIP.getTipoDeVaga());
        assertTrue(vagaVIP.isStatus());

        Vaga vagaComum = Vaga.criarVaga("003", false, "COMUM");
        assertEquals("003", vagaComum.getIdVaga());
        assertEquals("Comum", vagaComum.getTipoDeVaga());
        assertFalse(vagaComum.isStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarVagaComTipoInvalido() {
        Vaga.criarVaga("004", false, "INVALIDO");
    }

    @Test
    public void testGetTaxa() {
        assertEquals(0.0, vaga.getTaxa(), 0.001);
    }
}
