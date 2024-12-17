package dao;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.data.BancoDados;
import exception.SomenteLetrasException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Clientes extends AbstractDAO {

    private List<Cliente> clientes;
    private static Clientes instance;

    private Clientes() {
        this.clientes = new ArrayList<>();
    }

    public static Clientes getInstance() {
        if (instance == null) {
            instance = new Clientes();
        }
        return instance;
    }

    public int inserirCliente(Cliente cliente) {
        Connection conn = BancoDados.getConexao();
        String sql = "INSERT INTO Cliente (NOME) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getNome());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro aoinserir cliente: " + e.getMessage());
        }
        return -1;
    }

    public Cliente consultarClientePorNome(String nomeCliente) throws SomenteLetrasException {
        validarSomenteLetras(nomeCliente);
        String comandoSQL = "SELECT * FROM CLIENTE WHERE NOME = ?";
        Cliente cliente = null;

        try (
                Connection conexao = BancoDados.getConexao(); PreparedStatement ps = conexao.prepareStatement(comandoSQL)) {
            ps.setString(1, nomeCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar cliente: " + e.getMessage());
        }

        return cliente;
    }

    public Cliente consultarClientePorId(int idCliente) {
        String comandoSQL = "SELECT * FROM CLIENTE WHERE ID = ?";
        Cliente cliente = null;

        try (
                Connection conexao = BancoDados.getConexao(); PreparedStatement ps = conexao.prepareStatement(comandoSQL)) {
            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = mapearCliente(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar cliente: " + e.getMessage());
        }

        return cliente;
    }

    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(rs.getString("NOME"));
        cliente.setIdentificador(rs.getInt("ID"));

        return cliente;
    }

    public static void validarSomenteLetras(String texto) throws SomenteLetrasException {
        if (!texto.matches("[a-zA-ZÀ-ÿ\\s]+")) {
            throw new SomenteLetrasException("O nome deve conter apenas letras.");
        }
    }
}
