/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Estacionamentos;
import DAO.Vagas;
import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.Model.Tiquete;
import com.mycompany.mavenproject1.Model.Vaga;
import com.mycompany.mavenproject1.Model.Veiculo;
import dao.Clientes;
import dao.Tiquetes;
import dao.Veiculos;
import exception.SomenteLetrasException;
import exception.ValidacaoPlacaExisteException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.AddTicketView;

/**
 *
 * @author João
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.menuView;

public class AddTicketController {

    private AddTicketView view;
    private Tiquetes ticketsDAO;
    private Estacionamentos estacionamentos;
    private Vagas vagas;

    public AddTicketController(ArrayList<Estacionamento> estacionamentos) {
        this.vagas = Vagas.getInstance();
        this.estacionamentos = Estacionamentos.getInstance();
        this.ticketsDAO = Tiquetes.getInstance();
        this.view = new AddTicketView();

        this.view.setTitle("Adicionar Ticket");

        this.view.getbtnConfirmar().addActionListener((e) -> {
            try {
                confirmar();
            } catch (IOException | SQLException ex) {
                Logger.getLogger(AddTicketController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Erro ao salvar o ticket: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SomenteLetrasException ex) {
                Logger.getLogger(AddTicketController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "O nome deve conter apenas letras." + ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            } catch (ValidacaoPlacaExisteException ex) {
                Logger.getLogger(AddTicketController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        this.view.getbtnVoltar().addActionListener((e) -> voltar());

        this.view.setVisible(true);
    }

    public void confirmar() throws IOException, SQLException, SomenteLetrasException, ValidacaoPlacaExisteException {
        String idEstacionamentoString = view.getTxtIdEstacionamento().getText();
        String nome = view.getTxtNomeCliente().getText();
        String placa = view.getMascaraPlaca().getText();
        String tipoDeVagaSelecionada = (String) view.getJcbOpcoesVaga().getSelectedItem();
        System.out.println("Tipo de vaga: " + tipoDeVagaSelecionada);

        if (idEstacionamentoString.trim().isEmpty() || nome.trim().isEmpty() || placa.trim().isEmpty() || placa.equals("___-____") || tipoDeVagaSelecionada == null || idEstacionamentoString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente clienteCadastrado = Clientes.getInstance().consultarClientePorNome(nome);
        if (clienteCadastrado == null) {
            JOptionPane.showMessageDialog(view, "Cliente não encontrado. Verifique o nome ou cadastre o cliente primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idEstacionamento;
        try {
            idEstacionamento = Integer.parseInt(idEstacionamentoString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "O ID do estacionamento deve ser um número válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Estacionamento estacionamento = Estacionamentos.getInstance().consultarEstacionamentoPorId(idEstacionamento);
        if (estacionamento == null) {
            JOptionPane.showMessageDialog(view, "Estacionamento não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Veiculos.getInstance().verificarPlacaExiste(placa)) {
            throw new ValidacaoPlacaExisteException("A placa " + placa + " não está cadastrada no sistema.");
        }

        Veiculo veiculo = new Veiculo(placa);
        Cliente cliente = new Cliente(nome);
        Vaga vaga = vagas.localizarVagaLivre(tipoDeVagaSelecionada, idEstacionamento);

        System.out.println("Vaga: " + vaga);

        if (vaga != null) {
            vaga.setStatus(true);
            Tiquete ticket = new Tiquete(veiculo, cliente, vaga, tipoDeVagaSelecionada);

            int idGerado = ticketsDAO.inserirTiquete(ticket, idEstacionamento);
            if (idGerado != -1) {
                JOptionPane.showMessageDialog(view, "Ticket salvo com sucesso! Código: " + idGerado);
                limparTela();
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao salvar o ticket no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Nenhuma vaga disponível para o tipo especificado.");
        }
    }

    private void voltar() {
        limparTela();
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void limparTela() {
        this.view.getTxtIdEstacionamento().setText("");
        this.view.getTxtNomeCliente().setText("");
        this.view.getMascaraPlaca().setText("");
    }
}
