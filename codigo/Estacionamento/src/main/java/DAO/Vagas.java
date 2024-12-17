/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.Model.Vaga;
import com.mycompany.mavenproject1.data.BancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LGGENGENHARIA
 */
public class Vagas {

    private List<Vaga> vagas;
    private static Vagas instance;

    private Vagas() {
        this.vagas = new ArrayList<>();
    }

    public static Vagas getInstance() {
        if (instance == null) {
            instance = new Vagas();
        }
        return instance;
    }

    public void gerarVagas(Estacionamento estacionamento, int estacionamentoId) {
        Connection conexao = BancoDados.getConexao();

        String[] tiposDeVaga = {"VIP", "PCD", "IDOSOS", "COMUM"};
        int[] quantidadeVagas = {
            estacionamento.getNumeroDeVagasVIP(),
            estacionamento.getNumeroDeVagasPCD(),
            estacionamento.getNumeroDeVagasIdosos(),
            estacionamento.getNumeroDeVagasComuns()
        };

        try {
            String sql = "INSERT INTO Vaga (tipo, ocupada, estacionamento_id) VALUES (?, FALSE, ?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                for (int i = 0; i < tiposDeVaga.length; i++) {
                    for (int j = 0; j < quantidadeVagas[i]; j++) {
                        ps.setString(1, tiposDeVaga[i]);
                        ps.setInt(2, estacionamentoId);
                        ps.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vaga localizarVagaLivre(String tipoDeVagaSelecionada, int idEstacionamento) {
        Connection conexao = BancoDados.getConexao();
        Vaga vagaLivre = null;

        String sql = "SELECT * FROM Vaga WHERE tipo = ? AND ocupada = 0 AND estacionamento_id = ? LIMIT 1;";

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, tipoDeVagaSelecionada);
            ps.setInt(2, idEstacionamento);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String idVaga = rs.getString("id");
                int ocupada = rs.getInt("ocupada");
                String tipo = rs.getString("tipo");

                System.out.println("Vaga encontrada: ID=" + idVaga + ", Tipo=" + tipo + ", Ocupada=" + ocupada);

                vagaLivre = Vaga.criarVaga(idVaga, ocupada == 1, tipo);
            } else {
                System.out.println("Nenhuma vaga livre encontrada para o tipo: " + tipoDeVagaSelecionada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vagaLivre;
    }

    public List<Vaga> carregarVagas(int estacionamentoId) {
        Connection conexao = BancoDados.getConexao();
        List<Vaga> listaVagas = new ArrayList<>();

        // Alterar o comando SQL para buscar as vagas de um estacionamento específico com base no ID
        String comandoSQL = "SELECT * FROM Vaga WHERE estacionamento_id = ?";

        try (PreparedStatement ps = conexao.prepareStatement(comandoSQL)) {
            // Definir o ID do estacionamento na consulta SQL
            ps.setInt(1, estacionamentoId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String idVaga = rs.getString("id");
                int ocupada = rs.getInt("ocupada");
                String tipo = rs.getString("tipo");

                // Criar o objeto Vaga a partir dos dados retornados do banco
                Vaga vaga = Vaga.criarVaga(idVaga, ocupada == 1, tipo);
                listaVagas.add(vaga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaVagas;
    }

    private void atualizarVagaNoBanco(Vaga vaga) {
        String sql = "UPDATE vaga SET ocupada = ? WHERE id = ?";
        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, vaga.isStatus());
            ps.setInt(2, Integer.parseInt(vaga.getIdVaga())); // Certifique-se que o ID é numérico
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar a vaga no banco: " + e.getMessage());
        }
    }

}
