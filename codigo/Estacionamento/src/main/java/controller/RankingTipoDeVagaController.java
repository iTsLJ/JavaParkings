package controller;

import com.mycompany.mavenproject1.Model.RankingTipoDeVaga;
import dao.Tiquetes;
import view.RankingTipoDeVagaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import view.RelatorisoMenuView;
import view.menuView;

public class RankingTipoDeVagaController {
    private RankingTipoDeVagaView view;
    private Tiquetes tiquetesDAO;

    public RankingTipoDeVagaController() {
        this.view = new RankingTipoDeVagaView();
        this.tiquetesDAO = Tiquetes.getInstance();
        initView();
    }

    private void initView() {
        view.setVisible(true);
        view.getBtnVoltar().addActionListener(e -> voltar());
 
      carregarRankingPorUtilizacoes();
    }

    // Carregar ranking por tipo de vaga com base nas utilizações
    private void carregarRankingPorUtilizacoes() {
        List<RankingTipoDeVaga> ranking = tiquetesDAO.obterRankingPorTipoDeVaga();
        ranking.sort((vaga1, vaga2) -> Integer.compare(vaga2.getUtilizacoes(), vaga1.getUtilizacoes()));

        DefaultTableModel model = (DefaultTableModel) view.getTableVaga().getModel();
        model.setRowCount(0); 

        for (RankingTipoDeVaga vaga : ranking) {
            model.addRow(new Object[]{
                vaga.getTipoDeVaga(),
                vaga.getUtilizacoes(), 
                vaga.getValorTotal() 
            });
        }
    }

    private void voltar() {
        view.dispose();
        RelatorisoMenuView relatorisoMenuView= new RelatorisoMenuView();
        new RelatorisoMenuController();
    }
}
