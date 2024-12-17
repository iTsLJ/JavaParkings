/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.data.BancoDados;
import javax.swing.JOptionPane;
import view.menuView;
import dao.Clientes;
import dao.Veiculos;
import exception.SomenteLetrasException;
import java.util.List;
import view.VisualizarClienteView;

/**
 *
 * @author Lucas
 */
public class VisualizarClienteController {

    private VisualizarClienteView view;
    private Clientes clientesDAO;
    private Veiculos veiculosDAO;

    public VisualizarClienteController() {
        this.view = new VisualizarClienteView();
        this.view.setVisible(true);
        this.clientesDAO = Clientes.getInstance();
        this.veiculosDAO = Veiculos.getInstance();

        this.view.getBtnConsultar().addActionListener((e) -> consultarCliente());
        this.view.getBtnVoltar().addActionListener((e) -> voltar());

        this.view.setVisible(true);
    }

    private void consultarCliente() {
        String idClienteText = view.getTextID().getText();
        String nome = view.getTextNome().getText();
        Cliente cliente = null;

        if (!idClienteText.isEmpty()) {
            try {
                int idCliente = Integer.parseInt(idClienteText);
                cliente = clientesDAO.consultarClientePorId(idCliente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "O ID deve ser um número válido.");
                return;
            }
        } else if (!nome.isEmpty()) {
            try {
                cliente = clientesDAO.consultarClientePorNome(nome);
            } catch (SomenteLetrasException e) {
                JOptionPane.showMessageDialog(view, e.getMessage());
                return;
            }
        } else {
            JOptionPane.showMessageDialog(view, "Informe o ID ou o Nome para realizar a consulta.\n");
            return;
        }
        if (cliente != null) {
            //concatenação
            StringBuilder resultado = new StringBuilder();
            resultado.append("ID: ").append(cliente.getIdentificador()).append("\n");
            resultado.append("Nome: ").append(cliente.getNome()).append("\n");
            resultado.append("Veículos:\n");

            List<String> placas = veiculosDAO.consultarPlacasPorCliente(cliente.getIdentificador());

            if (!placas.isEmpty()) {
                for (String placa : placas) {
                    resultado.append(" - ").append(placa).append("\n");
                }
            } else {
                resultado.append("");
            }

            view.getTextArea1().setText(resultado.toString());
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(view, "Cliente não encontrado.");
            limparTela();
        }
    }

    private void voltar() {
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void limparCampos() {
        this.view.getTextID().setText("");
        this.view.getTextNome().setText("");
    }

    private void limparTela() {
        this.view.getTextID().setText("");
        this.view.getTextNome().setText("");
        this.view.getTextArea1().setText("");
    }

}
