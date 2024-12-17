/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Estacionamentos;
import DAO.Vagas;
import com.mycompany.mavenproject1.Model.Tiquete;
import dao.Tiquetes;
import exception.SomenteLetrasException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.FinalizarTicketView;
import view.menuView;

/**
 *
 * @author Lucas
 */
public class FinalizarTicketController {

    private FinalizarTicketView view;
    private Tiquetes ticketsDAO;
    private Estacionamentos estacionamentos;
    private Vagas vagas;

    public FinalizarTicketController() {
        this.view = new FinalizarTicketView();
        this.ticketsDAO = Tiquetes.getInstance();
        this.view.setVisible(true);

        this.view.getjButtonFinalizar().addActionListener((e) -> {
            try {
                finalizar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "O código do ticket deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.view.getjButtonVoltar().addActionListener((e) -> voltar());
    }

    private void finalizar() {
        try {
            String idTicketString = view.getjTextID().getText().trim();
            if (idTicketString.isEmpty()) {
                throw new IllegalArgumentException("Por favor, insira o código do ticket.");
            }
            int idTicket = Integer.parseInt(idTicketString);

            Tiquete tiquete = ticketsDAO.consultarTiquetePorCodigo(idTicket);
            if (tiquete == null) {
                throw new IllegalArgumentException("Ticket não encontrado para o código informado.");
            }
            
            if (!tiquete.isStatus()) {
                throw new IllegalArgumentException("Ticket já foi finalizado.");
            }

            float valor = ticketsDAO.calcularValorETerminarTiquete(idTicket);
            if (valor == -1) {
                throw new IllegalArgumentException("Erro ao finalizar o ticket. Verifique os dados e tente novamente.");
            }

            String veiculoPlaca = tiquete.getVeiculo().getPlaca();
            String clienteNome = tiquete.getCliente().getNome();
            String idVaga = tiquete.getVaga().getIdVaga();
            String tipoDeVaga = tiquete.getTipoDeVaga();
            String horarioEntrada = tiquete.getHorarioDeEntrada().toString();
            String data = tiquete.getData().toString(); 

            StringBuilder detalhesTicket = new StringBuilder();
            detalhesTicket.append("Ticket Finalizado com Sucesso\n");
            detalhesTicket.append("------------------------------\n");
            detalhesTicket.append("Código do Ticket: ").append(idTicket).append("\n");
            detalhesTicket.append("Placa do Veículo: ").append(veiculoPlaca).append("\n");
            detalhesTicket.append("Nome do Cliente: ").append(clienteNome).append("\n");
            detalhesTicket.append("Número da Vaga: ").append(idVaga).append("\n");
            detalhesTicket.append("Data: ").append(data).append("\n");
            detalhesTicket.append("Tipo de Vaga: ").append(tipoDeVaga).append("\n");
            detalhesTicket.append("Horário de Entrada: ").append(horarioEntrada).append("\n");

            if (valor == 0) {
                detalhesTicket.append("Valor a Pagar: Não há cobrança.\n");
            } else {
                detalhesTicket.append(String.format("Valor a Pagar: R$ %.2f\n", valor));
            }

            view.getjTextArea().setText(detalhesTicket.toString());
            this.view.getjTextID().setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "O código do ticket deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            limparTela();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            limparTela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Ocorreu um erro ao finalizar o ticket: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            limparTela();
        }
    }

    private void voltar() {
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void limparTela() {
        this.view.getjTextID().setText("");
        this.view.getjTextArea().setText("");
    }

}
