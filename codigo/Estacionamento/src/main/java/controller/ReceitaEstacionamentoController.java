/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Estacionamentos;
import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.Model.ReceitaEstacionamento;
import com.mycompany.mavenproject1.Model.Vaga;
import dao.Tiquetes;
import java.util.List;
import javax.swing.JOptionPane;
import view.ReceitaEstacionamentoView;
import view.RelatorisoMenuView;
import view.VerEstacionamentoView;
import view.menuView;

/**
 *
 * @author mateu
 */
public class ReceitaEstacionamentoController {

    private ReceitaEstacionamentoView view;
    private Estacionamentos estacionamentos;

    public ReceitaEstacionamentoController() {
        this.estacionamentos = Estacionamentos.getInstance();
        this.view = new ReceitaEstacionamentoView();

        this.view.getBtnConfirmar().addActionListener((e) -> {
            voltar();
        });
        this.view.getBtnVisualizar().addActionListener((e) -> {
            visualizar();
        });

        this.view.setVisible(true);
    }

    private void visualizar() {
        String idEstacionamentoTxt = view.getTxtID().getText();

        try {
            int estacionamentoId = Integer.parseInt(idEstacionamentoTxt);
            Estacionamento estacionamento = Estacionamentos.getInstance().consultarEstacionamentoPorId(estacionamentoId);
            if (estacionamento == null) {
                JOptionPane.showMessageDialog(view, "Estacionamento não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Tiquetes tiquetesDAO = Tiquetes.getInstance();

            ReceitaEstacionamento receita = tiquetesDAO.obterReceitaPorEstacionamento(estacionamentoId);

            if (receita != null) {
                StringBuilder resultado = new StringBuilder();
                resultado.append("Receita Total: R$ ").append(receita.getTotalReceita()).append("\n");
                resultado.append("Quantidade de Tiquetes: ").append(receita.getQuantidadeTiquetes()).append("\n");
                resultado.append("Valor Médio por Tiquete: R$ ").append(receita.getValorMedio()).append("\n");

                // Exibe o resultado no JTextArea
                view.getjTextArea().setText(resultado.toString());
            } else {
                JOptionPane.showMessageDialog(view, "Nenhum tiquete encontrado para o estacionamento com ID: " + estacionamentoId, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "O ID deve ser um número válido: ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltar() {
        view.dispose();
        RelatorisoMenuView relatorisoMenuView = new RelatorisoMenuView();
        new RelatorisoMenuController();
    }

}
