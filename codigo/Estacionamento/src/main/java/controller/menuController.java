package controller;

import DAO.Estacionamentos;
import com.mycompany.mavenproject1.Model.Estacionamento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import view.menuView;
import view.AddEstacionamentoView;

public class menuController {

    private menuView view;

    // Construtor que inicializa a view e chama initialize
    public menuController(menuView view) {
        this.view = view;
        this.view.setVisible(true); // Exibe o menu principal
        initialize();
    }

    //Método de configuração dos listeners dos botões
    private void initialize() {
        view.getbntAddEstacionamento().addActionListener(e -> addEstacionamento());
        view.getbntAddCliente().addActionListener(e -> addCliente());
        view.getbntAddVeiculo().addActionListener(e -> addVeiculo());
        view.getbntAddTiquete().addActionListener(e -> iniciarTiquete());
        view.getbntFinalisarTiquete().addActionListener(e -> finalizarTiquete());
        view.getbntVisualisarEstacionamneto().addActionListener(e -> visualizarEstacionamento());
        view.getbntVisualisarCliente().addActionListener(e -> visualizarCliente());
        view.getbntVisualisarTiquete().addActionListener(e -> visualizarTiquete());
        view.getbntRelatorios().addActionListener(e -> relatoris());
        view.getbntSair().addActionListener(e -> sair());
    }

    private void addEstacionamento() {
        // Fecha a tela do menu e abre a tela de Adicionar Estacionamento
        view.dispose();
        AddEstacionamentoController addEstacionamentoController = new AddEstacionamentoController(); 
    }

    private void addCliente() {
        view.dispose();
        AddClienteController addClienteController = new AddClienteController();
    }

    private void addVeiculo() {
        view.dispose();
        AddVeiculoController addVeiculoController = new AddVeiculoController();
    }

    private void iniciarTiquete() {
        view.dispose();
        Scanner ler = new Scanner(System.in);

        ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
        Estacionamento estacionamento = null; // Inicializando como null
        int menu = 0;
        AddTicketController addTicketController = new AddTicketController(estacionamentos);
    }

    private void finalizarTiquete() {
        view.dispose();
        FinalizarTicketController finalizarTicketController = new FinalizarTicketController(); 
    }

    private void visualizarEstacionamento() {

        view.setVisible(false);
        VerEstacionamentoController verEstacionamentoController = new VerEstacionamentoController(); 
    }

    private void visualizarCliente() {
        view.dispose();
        VisualizarClienteController visualizarClienteController = new VisualizarClienteController();
    }

    private void visualizarTiquete() {
        view.dispose();
        VerTicketsController verTicketsController = new VerTicketsController();
    }
    
    private void relatoris(){
        view.dispose();
        RelatorisoMenuController relatorisoMenuController = new RelatorisoMenuController();
        }

    private void sair() {
        System.exit(0);
    }

    public static void main(String[] args) {
        menuView menuView = new menuView();

        menuController menuController = new menuController(menuView);
    }

}
