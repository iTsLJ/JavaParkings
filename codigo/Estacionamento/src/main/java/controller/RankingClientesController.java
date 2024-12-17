package controller;

import com.mycompany.mavenproject1.Model.RankingCliente;

import dao.Tiquetes;
import view.RankingClientesView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import view.RelatorisoMenuView;

public class RankingClientesController {

    private RankingClientesView view;
    private Tiquetes tiquetesDAO;

    public RankingClientesController(RankingClientesView view) {
        this.view = view;
        this.tiquetesDAO = Tiquetes.getInstance();
        initView();
    }

    private void initView() {
        view.setVisible(true);
        view.getBntValor().addActionListener(e -> carregarRankingPorValor());
        view.getBntUtilisaçoes().addActionListener(e -> carregarRankingPorUtilizacoes());
        view.getBntVoltar().addActionListener(e -> voltar());
    }

    private void carregarRankingPorValor() {
        List<RankingCliente> ranking = tiquetesDAO.obterRankingClientes();

        // Ordenar a lista de RankingCliente do maior para o menor valor total
        ranking.sort((cliente1, cliente2) -> Double.compare(cliente2.getValorTotal(), cliente1.getValorTotal()));

        DefaultTableModel model = (DefaultTableModel) view.getTabelaRanking().getModel();
        model.setRowCount(0); // Limpar a tabela

        for (RankingCliente cliente : ranking) {
            model.addRow(new Object[]{
                cliente.getNome(),
                cliente.getValorTotal(),
                cliente.getUtilizacoes()
            });
        }
    }

    private void carregarRankingPorUtilizacoes() {
        List<RankingCliente> ranking = tiquetesDAO.obterRankingClientes();

        // Ordenar a lista de RankingCliente do maior para o menor número de utilizações
        ranking.sort((cliente1, cliente2) -> Integer.compare(cliente2.getUtilizacoes(), cliente1.getUtilizacoes()));

        DefaultTableModel model = (DefaultTableModel) view.getTabelaRanking().getModel();
        model.setRowCount(0); // Limpar a tabela

        for (RankingCliente cliente : ranking) {
            model.addRow(new Object[]{
                cliente.getNome(),
                cliente.getValorTotal(),
                cliente.getUtilizacoes()
            });
        }
    }

    private void voltar() {
        view.dispose();
        RelatorisoMenuView relatorisoMenuView = new RelatorisoMenuView();
        new RelatorisoMenuController();
    }
}
