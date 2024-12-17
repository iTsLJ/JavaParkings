package controller;

import DAO.Estacionamentos;
import DAO.Vagas;
import com.mycompany.mavenproject1.Model.Estacionamento;
import view.AddEstacionamentoView;
import view.menuView;

import javax.swing.*;
import java.io.IOException;

public class AddEstacionamentoController {

    private AddEstacionamentoView view;
    private Estacionamentos estacionamentos;
    private Vagas vagas;

    public AddEstacionamentoController() {
        this.vagas = Vagas.getInstance();
        this.estacionamentos = Estacionamentos.getInstance();
        this.view = new AddEstacionamentoView();
        carregarEstacionamentos();
        this.view.setVisible(true);

        this.view.getBtnConfirmar().addActionListener(e -> addEstacionamento());
        this.view.getBtnVoltar().addActionListener(e -> voltar());
    }

    private void carregarEstacionamentos() {
        estacionamentos.carregarEstacionamentos();
    }

    public void addEstacionamento() {
        String nome = this.view.getTxtEstacionamento().getText();
        String vagasVIP = this.view.getTxtVagasVIP().getText();
        String vagasPCD = this.view.getTxtVagasPCD().getText();
        String vagasIdosos = this.view.getTxtVagasIdosos().getText();
        String vagasComuns = this.view.getTxtVagas().getText();

        try {
            int numVagasVIP = Integer.parseInt(vagasVIP);
            int numVagasPCD = Integer.parseInt(vagasPCD);
            int numVagasIdosos = Integer.parseInt(vagasIdosos);
            int numVagasComuns = Integer.parseInt(vagasComuns);

            Estacionamento estacionamento = new Estacionamento(numVagasVIP, numVagasPCD, numVagasIdosos, numVagasComuns, nome, 0);
            int idGerado = estacionamentos.inserirEstacionamento(estacionamento);

            if (idGerado != -1) {
                vagas.gerarVagas(estacionamento, idGerado);
                JOptionPane.showMessageDialog(this.view, "Estacionamento criado com sucesso! ID: " + idGerado);
                limparTela();
                voltar();
            } else {
                JOptionPane.showMessageDialog(this.view, "Erro ao cadastrar estacionamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Por favor, insira valores numéricos válidos para as vagas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparTela() {
        this.view.getTxtEstacionamento().setText("");
        this.view.getTxtVagasVIP().setText("");
        this.view.getTxtVagasPCD().setText("");
        this.view.getTxtVagasIdosos().setText("");
        this.view.getTxtVagas().setText("");
    }

    private void voltar() {
        this.view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }
}
