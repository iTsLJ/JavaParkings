/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.RankingClientesView;
import view.ReceitaMesEstacionamentoView;
import view.RelatorisoMenuView;
import view.RankingTipoDeVagaView;
import view.menuView;

/**
 *
 * @author mateu
 */
public class RelatorisoMenuController {

    private RelatorisoMenuView view;

    public RelatorisoMenuController() {
        this.view = new RelatorisoMenuView();
        this.view.setVisible(true);
        initialize();
    }

    private void initialize() {
        view.getBntArecadacaoMes().addActionListener(e -> arecadacaoMes());
        view.getBntRankingClientes().addActionListener(e -> RankingClientes());
        view.getBntReceitaEstacionamento().addActionListener(e -> ReceitaEstacionamento());
        view.getBntRankingVagas().addActionListener(e -> RankingVagas());
        view.getBtnHistoricoCliente().addActionListener(e -> HistoricoCliente());
        view.getBtnVoltar().addActionListener(e -> voltar());

    }

    private void arecadacaoMes() {
        view.dispose();
        ReceitaMesEstacionamentoView view = new ReceitaMesEstacionamentoView();
        new ReceitaMesEstacionamentoController(view);
        view.setVisible(true);
    }

    private void RankingClientes() {
        view.dispose(); // Fecha a view atual
        RankingClientesView rankingView = new RankingClientesView(); // Cria uma nova instância da view
        RankingClientesController rankingClientesController = new RankingClientesController(rankingView); // Passa a view para o controlador
    }

    private void ReceitaEstacionamento() {
        view.dispose();
        ReceitaEstacionamentoController receitaEstacionamentoController = new ReceitaEstacionamentoController();

    }

    private void ValorMedio() {

    }

    private void sair() {
        view.dispose();
        RelatorisoMenuView relatoriosView = new RelatorisoMenuView();
    }

    private void voltar() {
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void RankingVagas() {
        view.dispose();
        RankingTipoDeVagaController rankingTipoDeVagaController = new RankingTipoDeVagaController();

    }

    private void HistoricoCliente() {
        view.dispose();
        HistoricoClienteController historicoClienteController = new HistoricoClienteController();
    }
}
