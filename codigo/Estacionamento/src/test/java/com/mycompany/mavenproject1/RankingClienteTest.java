package com.mycompany.mavenproject1;

import org.junit.Before;
import org.junit.Test;
import com.mycompany.mavenproject1.Model.RankingCliente;

import static org.junit.Assert.*;

public class RankingClienteTest {

    private RankingCliente rankingCliente;

    @Before
    public void setUp() {
        // Inicializando a instância antes de cada teste
        rankingCliente = new RankingCliente("João", 500.0f, 10); // Nome: João, Valor Total: 500.0, Utilizações: 10
    }

    @Test
    public void testGetNome() {
        // Verificando se o nome do cliente está correto
        assertEquals("João", rankingCliente.getNome());
    }

    @Test
    public void testGetValorTotal() {
        // Verificando se o valor total está correto
        assertEquals(500.0f, rankingCliente.getValorTotal(), 0.001f); // O valor total é 500.0
    }

    @Test
    public void testGetUtilizacoes() {
        // Verificando se o número de utilizações está correto
        assertEquals(10, rankingCliente.getUtilizacoes());
    }
}
