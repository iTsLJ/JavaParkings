package controller;

import DAO.Estacionamentos;
import com.mycompany.mavenproject1.Model.Tiquete;
import dao.Tiquetes;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.VisualizarTicketsView;
import view.menuView;

/**
 *
 * @author João
 */
public class VerTicketsController {

    private VisualizarTicketsView view;
    private Estacionamentos estacionamento;
    private Tiquetes tickets;

    public VerTicketsController() {
        this.estacionamento = Estacionamentos.getInstance();
        this.view = new VisualizarTicketsView();
        this.view.setVisible(true);

        this.view.setVisible(true);
        this.tickets = Tiquetes.getInstance();
        carregaTabela();
        this.view.getBtnVoltar().addActionListener((e) -> voltar());
    }

    private void voltar() {
        this.view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void carregaTabela() {
        Object colunas[] = {"Código", "Cliente", "Placa", "Vaga", "Tipo", "Data", "Horario", "Status"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);

        // Obtém os tiquetes diretamente do banco de dados
        List<Tiquete> listaTiquetes = tickets.obterTodosTiquetesDoBD();

        for (Tiquete t : listaTiquetes) {
            tm.addRow(new Object[]{
                t.getCodigo(),
                t.getCliente().getNome(),
                t.getVeiculo().getPlaca(),
                t.getVaga().getIdVaga(),
                t.getTipoDeVaga(),
                t.getData(),
                t.getHorarioDeEntrada().toString(),
                t.isStatus() ? "Ativo" : "Finalizado"
            });
        }

        view.getTbCarros().setModel(tm);
    }

}
