/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.data.BancoDados;
import exception.PlacaDuplicadaException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Veiculos extends AbstractDAO {

    private static Veiculos instance;

    public Veiculos() {
    }

    public static Veiculos getInstance() {
        if (instance == null) {
            instance = new Veiculos();
        }
        return instance;
    }

    public void inserirVeiculo(Veiculo veiculo, int idCliente) throws PlacaDuplicadaException {
        String verificarClienteSQL = "SELECT COUNT(*) FROM Cliente WHERE ID = ?";
        try (Connection conexao = BancoDados.getConexao(); PreparedStatement ps = conexao.prepareStatement(verificarClienteSQL)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    throw new IllegalArgumentException("Cliente com ID " + idCliente + " não encontrado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar cliente: " + e.getMessage());
            return;
        }

        String verificarPlacaSQL = "SELECT COUNT(*) FROM Veiculo WHERE PLACA = ?";
        try (Connection con = BancoDados.getConexao(); PreparedStatement ps = con.prepareStatement(verificarPlacaSQL)) {
            ps.setString(1, veiculo.getPlaca());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    throw new PlacaDuplicadaException("A placa " + veiculo.getPlaca() + " já está cadastrada.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar placa: " + e.getMessage());
            return;
        }

        String comandoSQL = "INSERT INTO Veiculo (ID_CLIENTE, PLACA) VALUES (?, ?)";
        try (Connection con = BancoDados.getConexao(); PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setInt(1, idCliente);
            ps.setString(2, veiculo.getPlaca());
            ps.executeUpdate();
            System.out.println("Veículo inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veículo: " + e.getMessage());
        }
    }

    public List<String> consultarPlacasPorCliente(int idCliente) {
        List<String> placas = new ArrayList<>();
        String sql = "SELECT PLACA FROM Veiculo WHERE ID_CLIENTE = ?";

        try (Connection con = BancoDados.getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String placa = rs.getString("PLACA");
                placas.add(placa);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar placas: " + e.getMessage());
        }

        return placas;
    }

    public boolean verificarPlacaExiste(String placa) {
        String sql = "SELECT COUNT(*) FROM Veiculo WHERE PLACA = ?";
        try (Connection con = BancoDados.getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, placa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;  // Placa encontrada no banco de dados
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar placa: " + e.getMessage());
        }
        return false;  // Placa não encontrada
    }

}
