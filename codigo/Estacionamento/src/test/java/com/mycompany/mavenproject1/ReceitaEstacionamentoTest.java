package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.ReceitaEstacionamento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;


public class ReceitaEstacionamentoTest {

    private ReceitaEstacionamento receitaEstacionamento;

    @Before
    public void setUp() {
        // Inicializando a instância antes de cada teste
        receitaEstacionamento = new ReceitaEstacionamento(1000.0f, 50); // Total Receita: 1000, Quantidade Tiquetes: 50
    }

    @Test
    public void testValorMedioCalculadoCorretamente() {
        // Verificando se o valor médio está correto (1000 / 50 = 20)
        assertEquals(20.0f, receitaEstacionamento.getValorMedio(), 0.001f); // A última parte é a margem de erro para valores flutuantes
    }

    @Test
    public void testValorMedioComZeroTiquetes() {
        // Criando um novo objeto com 0 tiquetes
        ReceitaEstacionamento receitaComZeroTiquetes = new ReceitaEstacionamento(1000.0f, 0);

        // O valor médio deve ser 0 quando a quantidade de tiquetes for 0
        assertEquals(0.0f, receitaComZeroTiquetes.getValorMedio(), 0.001f);
    }

    @Test
    public void testGetTotalReceita() {
        // Verificando o valor total da receita
        assertEquals(1000.0f, receitaEstacionamento.getTotalReceita(), 0.001f);
    }

    @Test
    public void testGetQuantidadeTiquetes() {
        // Verificando a quantidade de tiquetes
        assertEquals(50, receitaEstacionamento.getQuantidadeTiquetes());
    }
}
