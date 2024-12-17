


package com.mycompany.mavenproject1.app;

import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.Model.Vaga;
import com.mycompany.mavenproject1.Model.Tiquete;
import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.Model.Cliente;
import controller.AddClienteController;
import controller.menuController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import view.menuView;

/*public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas para armazenar dados carregados
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
        ArrayList<Tiquete> tiketesList = new ArrayList<>();

        // Carregar dados de arquivos
        try {
            clientes = Cliente.carregarClientesDoArquivo();
            estacionamentos = Estacionamento.carregarEstacionamentoDoArquivo();
            tiketesList = Tiquete.carregarTiketesDoArquivo();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        // Inicializa a visão e o controlador do menu
        menuView view = new menuView();
        menuController menuController = new menuController(view);

       
        // Salvar dados nos arquivos ao sair
        try {
             new Cliente("").salvarClientesEmArquivo(clientes); 
            for (Tiquete tiket : tiketesList) {
                tiket.salvarTiketesEmArquivo();
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }

        // Fechar scanner
        scanner.close();
    }
}*/
