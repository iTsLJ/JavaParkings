/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Estacionamentos;
import DAO.Vagas;
import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.Model.Vaga;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.VerEstacionamentoView;
import view.menuView;

/**
 *
 * @author nanda
 */
public class VerEstacionamentoController {

    private VerEstacionamentoView view;
    private Estacionamentos estacionamentos;

    public VerEstacionamentoController() {
        this.estacionamentos = Estacionamentos.getInstance();
        this.view = new VerEstacionamentoView();

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

            Estacionamento estacionamentoEncontrado = estacionamentos.consultarEstacionamentoPorId(estacionamentoId);

            if (estacionamentoEncontrado == null) {
                JOptionPane.showMessageDialog(view, "Estacionamento não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nome = estacionamentoEncontrado.getNome();
            int vagasVIP = estacionamentoEncontrado.getNumeroDeVagasVIP();
            int vagasPCD = estacionamentoEncontrado.getNumeroDeVagasPCD();
            int vagasIdoso = estacionamentoEncontrado.getNumeroDeVagasIdosos();
            int vagasComuns = estacionamentoEncontrado.getNumeroDeVagasComuns();

            Vagas vagasDAO = Vagas.getInstance();
            List<Vaga> listaVagas = vagasDAO.carregarVagas(estacionamentoId);

            int vagasLivres = 0;
            int vagasOcupadas = 0;

            for (Vaga vaga : listaVagas) {
                if (vaga.isStatus()) {
                    vagasOcupadas++;
                } else {
                    vagasLivres++;
                }
            }

            // Construção do texto com StringBuilder
            StringBuilder visualizar = new StringBuilder();
            visualizar.append("Detalhes do Estacionamento\n");
            visualizar.append("--------------------------\n");
            visualizar.append("Nome: ").append(nome).append("\n");
            visualizar.append("Total de Vagas VIP: ").append(vagasVIP).append("\n");
            visualizar.append("Total de Vagas PCD: ").append(vagasPCD).append("\n");
            visualizar.append("Total de Vagas para Idosos: ").append(vagasIdoso).append("\n");
            visualizar.append("Total de Vagas Comuns: ").append(vagasComuns).append("\n");
            visualizar.append("Vagas Livres: ").append(vagasLivres).append("\n");
            visualizar.append("Vagas Ocupadas: ").append(vagasOcupadas).append("\n");

            // Exibe o texto no JTextArea
            view.getjTextArea().setText(visualizar.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "O ID deve ser um número válido: ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltar() {
        this.view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

}
