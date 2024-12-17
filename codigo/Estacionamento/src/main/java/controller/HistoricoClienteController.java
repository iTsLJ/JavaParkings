/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.mavenproject1.Model.Cliente;
import dao.Clientes;
import dao.Tiquetes;
import java.util.List; // Importando a classe List
import view.HistoricoClienteView;
import com.mycompany.mavenproject1.Model.Tiquete;
import exception.SomenteLetrasException;
import javax.swing.JOptionPane;
import view.RelatorisoMenuView;

/**
 *
 * @author Lucas
 */
public class HistoricoClienteController {

    private HistoricoClienteView view;
    private Clientes clientesDAO;
    private Tiquetes TiquetesDAO;

    public HistoricoClienteController() {
        this.view = new HistoricoClienteView();
        this.clientesDAO = Clientes.getInstance();
        this.TiquetesDAO = Tiquetes.getInstance();

        this.view.getBtnHistorico().addActionListener((e) -> historico());
        this.view.getBtnVoltar().addActionListener((e) -> voltar());

        this.view.setVisible(true);

    }

    private void historico() {
        String nome = view.getTxtNome().getText();
        Cliente cliente = null;

        if (!nome.isEmpty()) {
            try {
                cliente = clientesDAO.consultarClientePorNome(nome);
            } catch (SomenteLetrasException e) {
                JOptionPane.showMessageDialog(view, e.getMessage());
                return;
            }
        }else{
            JOptionPane.showMessageDialog(view, "Insira um Nome para visualizar o historico.\n");
            return;
        }

        List<Tiquete> historico = TiquetesDAO.obterHistoricoPorCliente(nome);

        StringBuilder resultado = new StringBuilder();

        if (!historico.isEmpty()) {
            for (Tiquete tiquete : historico) {
                resultado.append("Código: ").append(tiquete.getCodigo()).append("\n");
                resultado.append("Vaga: ").append(tiquete.getVaga().getIdVaga()).append("\n");
                resultado.append("Tipo de Vaga: ").append(tiquete.getTipoDeVaga()).append("\n");
                resultado.append("Veículo: ").append(tiquete.getVeiculo().getPlaca()).append("\n");
                resultado.append("Data de Entrada: ").append(tiquete.getData()).append("\n");
                resultado.append("Hora de Entrada: ").append(tiquete.getHorarioDeEntrada()).append("\n");
                resultado.append("Status: ").append(tiquete.isStatus() ? "Ativo" : "Finalizado").append("\n");
                resultado.append("---------\n");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Nenhum histórico encontrado para o cliente .");
        }

        view.getjTextAreaHistorico().setText(resultado.toString());
        limparCampos();
    }

    private void limparCampos() {
        this.view.getTxtNome().setText("");
    }

    private void voltar() {
        view.dispose();
        RelatorisoMenuView relatorisoMenuView = new RelatorisoMenuView();
        new RelatorisoMenuController();
    }

}
