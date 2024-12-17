package controller;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.data.BancoDados;
import javax.swing.JOptionPane;
import view.AddClienteView;
import view.menuView;
import dao.Clientes;
import static dao.Clientes.validarSomenteLetras;
import exception.SomenteLetrasException;

public class AddClienteController {

    private AddClienteView view;
    private Clientes clientesDAO;

    public AddClienteController() {
        this.view = new AddClienteView();
        this.view.setVisible(true);
        this.clientesDAO = Clientes.getInstance();
        inicialize();
    }

    private void inicialize() {
        view.getbtnCriar().addActionListener(e -> criar());
        view.getbtnVoltar().addActionListener(e -> voltar());
    }

    private void criar() {
        String nome = view.gettxtNome().getText();
        boolean anonimo = view.getckbClienteAnonimo().isSelected();

        try {
            if (nome.trim().isEmpty() && anonimo) {
                nome = "Anônimo";
            } else if (nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha o nome ou selecione 'Cliente Anônimo'.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
            return;
        }

        if (!"Anônimo".equals(nome)) {
            try {
                validarSomenteLetras(nome);
            } catch (SomenteLetrasException e) {
                JOptionPane.showMessageDialog(view, e.getMessage());
                return;
            }
        }

        Cliente novoCliente = new Cliente(nome);

        int idCliente = clientesDAO.inserirCliente(novoCliente);
        novoCliente.setIdentificador(idCliente);

        view.getLbIDcliente().setText(String.valueOf(idCliente));

        JOptionPane.showMessageDialog(view, "Cliente criado com sucesso!");

        limparTela();
    }

    private void voltar() {
        limparTela();
        view.dispose();
        menuView menuView = new menuView();
        new menuController(menuView);
    }

    private void limparTela() {
        this.view.gettxtNome().setText("");
        this.view.getckbClienteAnonimo().setSelected(false);
    }

}
