package controller;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.data.BancoDados;
import dao.Veiculos;
import exception.PlacaDuplicadaException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.AddVeiculoView;
import view.menuView;

public class AddVeiculoController {

    private AddVeiculoView view;
    private Veiculos veiculosDAO;

    public AddVeiculoController() {
        this.view = new AddVeiculoView();
        this.view.setVisible(true);
        this.veiculosDAO = Veiculos.getInstance();

        this.view.getjButtonCadastarVeiculo().addActionListener((e) -> cadastrarVeiculo());
        this.view.getVoltar().addActionListener((e) -> voltar());

        this.view.setVisible(true);
    }

    private void cadastrarVeiculo() {
        String idClienteText = view.getjTextPaneID().getText();
        String placa = view.getjFormattedPlaca().getText().toUpperCase();

        if (idClienteText.trim().isEmpty() || placa.trim().isEmpty() || placa.equals("___-____")) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!");
            return;
        }

        int idCliente;
        try {
            idCliente = Integer.parseInt(idClienteText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "ID do cliente inválido. Por favor, insira um número válido.");
            return;
        }

        Veiculo veiculo = new Veiculo(placa);

        try {
            veiculosDAO.inserirVeiculo(veiculo, idCliente);
            JOptionPane.showMessageDialog(view, "Veículo cadastrado com sucesso!");
        } catch (PlacaDuplicadaException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }

        view.getjTextPaneID().setText("");
        view.getjFormattedPlaca().setText("");
    }

    private void voltar() {
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

}
