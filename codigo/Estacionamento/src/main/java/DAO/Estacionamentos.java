package DAO;

import com.mycompany.mavenproject1.Model.Estacionamento;
import com.mycompany.mavenproject1.data.BancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Estacionamentos {

    private ArrayList<Estacionamento> estacionamentos;
    private static Estacionamentos instance;

    private Estacionamentos() {
        this.estacionamentos = new ArrayList<>();
    }

    public static Estacionamentos getInstance() {
        if (instance == null) {
            instance = new Estacionamentos();
        }
        return instance;
    }

    public ArrayList<Estacionamento> getEstacionamentos() {
        return estacionamentos;
    }

    public int inserirEstacionamento(Estacionamento estacionamento) {
        Connection conn = BancoDados.getConexao();
        String sql = "INSERT INTO Estacionamento (NOME, VAGAS_VIP, VAGAS_PCD, VAGAS_IDOSOS, VAGAS_COMUNS) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, estacionamento.getNome());
            stmt.setInt(2, estacionamento.getNumeroDeVagasVIP());
            stmt.setInt(3, estacionamento.getNumeroDeVagasPCD());
            stmt.setInt(4, estacionamento.getNumeroDeVagasIdosos());
            stmt.setInt(5, estacionamento.getNumeroDeVagasComuns());

            int rowsAffected = stmt.executeUpdate();

            // Se a inserção for bem-sucedida, retorna o ID do estacionamento gerado
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Retorna o ID gerado
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }

    public void carregarEstacionamentos() {
        String sql = "SELECT * FROM Estacionamento";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            estacionamentos.clear();

            while (rs.next()) {
                Estacionamento estacionamento = mapearEstacionamento(rs);
                estacionamentos.add(estacionamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Estacionamento consultarEstacionamentoPorId(int idEstacionamento) {
    String comandoSQL = "SELECT * FROM Estacionamento WHERE ID = ?";
    Estacionamento estacionamento = null;

    try (Connection conn = BancoDados.getConexao();
         PreparedStatement ps = conn.prepareStatement(comandoSQL)) {
        
        // Setando o ID na consulta
        ps.setInt(1, idEstacionamento);
        
        try (ResultSet rs = ps.executeQuery()) {
            // Verificando se o estacionamento foi encontrado
            if (rs.next()) {
                // Utilizando o método mapearEstacionamento para mapear os dados do ResultSet
                estacionamento = mapearEstacionamento(rs);
                // Adicionando o ID para que o estacionamento tenha o ID carregado
                estacionamento.setIdEstacionamento(rs.getInt("ID"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Retorna o estacionamento encontrado, ou null se não encontrado
    return estacionamento;
}

    private Estacionamento mapearEstacionamento(ResultSet rs) throws SQLException {
        int vagasVIP = rs.getInt("VAGAS_VIP");
        int vagasPCD = rs.getInt("VAGAS_PCD");
        int vagasIdosos = rs.getInt("VAGAS_IDOSOS");
        int vagasComuns = rs.getInt("VAGAS_COMUNS");
        String nome = rs.getString("NOME");

        Estacionamento estacionamento = new Estacionamento(vagasVIP, vagasPCD, vagasIdosos, vagasComuns, nome, 0);
        return estacionamento;
    }

    public ArrayList<Estacionamento> obterTodosEstacionamentosDoBD() {
        ArrayList<Estacionamento> listaEstacionamentos = new ArrayList<>();
        String sql = "SELECT * FROM Estacionamento";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Estacionamento estacionamento = mapearEstacionamento(rs);
                listaEstacionamentos.add(estacionamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter todos os estacionamentos: " + e.getMessage());
        }

        return listaEstacionamentos;
    }

}
