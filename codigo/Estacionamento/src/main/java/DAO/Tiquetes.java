package dao;

import com.mycompany.mavenproject1.Model.Cliente;
import com.mycompany.mavenproject1.Model.RankingCliente;
import com.mycompany.mavenproject1.Model.RankingTipoDeVaga;
import com.mycompany.mavenproject1.Model.ReceitaEstacionamento;
import com.mycompany.mavenproject1.Model.ReceitasMesEstacionamento;
import com.mycompany.mavenproject1.Model.Tiquete;
import com.mycompany.mavenproject1.Model.Vaga;
import com.mycompany.mavenproject1.Model.Veiculo;
import com.mycompany.mavenproject1.data.BancoDados;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Tiquetes extends AbstractDAO {

    private List<Tiquete> tiquetes;
    private static Tiquetes instance;

    private Tiquetes() {
        this.tiquetes = new ArrayList<>();
    }

    public static Tiquetes getInstance() {
        if (instance == null) {
            instance = new Tiquetes();
        }
        return instance;
    }

    public int inserirTiquete(Tiquete tiquete, int idEstacionamento) {
        Connection conn = BancoDados.getConexao();
        String inserirTiqueteSQL = "INSERT INTO Tiquete (codigo, ID_Estacionamento, veiculo, cliente, vaga, tipoDeVaga, data, horarioDeEntrada, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String atualizarVagaSQL = "UPDATE vaga SET ocupada = 1 WHERE id = ?";

        try (PreparedStatement psTicket = conn.prepareStatement(inserirTiqueteSQL, Statement.RETURN_GENERATED_KEYS); PreparedStatement psVaga = conn.prepareStatement(atualizarVagaSQL)) {

            psTicket.setInt(1, tiquete.getCodigo());
            psTicket.setInt(2, idEstacionamento);
            psTicket.setString(3, tiquete.getVeiculo().getPlaca());
            psTicket.setString(4, tiquete.getCliente().getNome());
            psTicket.setString(5, tiquete.getVaga().getIdVaga());
            psTicket.setString(6, tiquete.getTipoDeVaga());
            psTicket.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            psTicket.setString(8, tiquete.getHorarioDeEntrada().format(DateTimeFormatter.ISO_LOCAL_TIME));
            psTicket.setBoolean(9, tiquete.isStatus());

            int rowsAffected = psTicket.executeUpdate();

            if (rowsAffected > 0) {
                psVaga.setInt(1, Integer.parseInt(tiquete.getVaga().getIdVaga()));
                psVaga.executeUpdate();

                try (ResultSet generatedKeys = psTicket.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir tiquete: " + e.getMessage());
        }
        return -1;
    }

    public Tiquete consultarTiquetePorCodigo(int codigo) {
        String sql = "SELECT * FROM Tiquete WHERE codigo = ?";
        Tiquete tiquete = null;

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tiquete = mapearTiquete(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar tiquete: " + e.getMessage());
        }

        return tiquete;
    }

    private Tiquete mapearTiquete(ResultSet rs) throws SQLException {
        int codigo = rs.getInt("codigo");
        if (codigo == 0) {
            System.err.println("Código inválido encontrado para o tiquete!");
        }
        String placaVeiculo = rs.getString("veiculo");
        String nomeCliente = rs.getString("cliente");
        String idVaga = rs.getString("vaga");
        String tipoDeVaga = rs.getString("tipoDeVaga");
        LocalTime horarioDeEntrada = LocalTime.parse(rs.getString("horarioDeEntrada"));
        LocalDate data = rs.getDate("data").toLocalDate();
        boolean status = rs.getBoolean("status");

        Veiculo veiculo = new Veiculo(placaVeiculo);
        Cliente cliente = new Cliente(nomeCliente);
        Vaga vaga = Vaga.criarVaga(idVaga, status, tipoDeVaga);

        Tiquete tiquete = new Tiquete(veiculo, cliente, vaga, tipoDeVaga);
        tiquete.setCodigo(codigo);
        tiquete.setHorarioDeEntrada(horarioDeEntrada);
        tiquete.setData(data);
        tiquete.setStatus(status);

        return tiquete;
    }

    public boolean atualizarTiquete(Tiquete tiquete) {
        String sql = "UPDATE Tiquete SET veiculo = ?, cliente = ?, vaga = ?, tipoDeVaga = ?, horarioDeEntrada = ?, status = ? WHERE codigo = ?";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tiquete.getVeiculo().getPlaca());
            ps.setString(2, tiquete.getCliente().getNome());
            ps.setString(3, tiquete.getVaga().getIdVaga());
            ps.setString(4, tiquete.getTipoDeVaga());
            ps.setString(5, tiquete.getHorarioDeEntrada().toString());
            ps.setBoolean(6, tiquete.isStatus());
            ps.setInt(7, tiquete.getCodigo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi atualizada
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tiquete: " + e.getMessage());
        }
        return false;
    }

    public float calcularValorETerminarTiquete(int codigoTiquete) {
        Tiquete tiquete = consultarTiquetePorCodigo(codigoTiquete);

        if (tiquete == null) {
            System.err.println("Tiquete não encontrado para o código: " + codigoTiquete);
            return -1;
        }

        float valor = calcularValor(tiquete);

        String sqlTiquete = "UPDATE Tiquete SET status = ?, horarioDeSaida = ?, valor = ? WHERE codigo = ?";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement psTiquete = conn.prepareStatement(sqlTiquete)) {

            psTiquete.setBoolean(1, false);
            psTiquete.setString(2, LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            psTiquete.setFloat(3, valor);
            psTiquete.setInt(4, codigoTiquete);

            int rowsAffectedTiquete = psTiquete.executeUpdate();

            if (rowsAffectedTiquete == 0) {
                System.err.println("Falha ao atualizar o tiquete no banco de dados.");
                return -1;
            }

            String vagaId = tiquete.getVaga().getIdVaga();

            String sqlVaga = "UPDATE Vaga SET ocupada = 0 WHERE ID = ?";
            try (PreparedStatement psVaga = conn.prepareStatement(sqlVaga)) {
                psVaga.setString(1, vagaId);
                int rowsAffectedVaga = psVaga.executeUpdate();

                if (rowsAffectedVaga == 0) {
                    System.err.println("Falha ao liberar a vaga no banco de dados.");
                    return -1;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao finalizar o tiquete ou liberar a vaga no banco de dados: " + e.getMessage());
            return -1;
        }

        return valor;
    }

    public float calcularValor(Tiquete tiquete) {
        LocalTime horarioDeSaida = LocalTime.now();
        int tempo = calcularTempo(tiquete.getHorarioDeEntrada(), horarioDeSaida);
        Vaga vaga = tiquete.getVaga();
        vaga.alterarStatus();
        double taxa = vaga.getTaxa();

        float valor = (tempo / 15) * 4; // Cobrança por frações de 15 minutos

        // Limitar o valor máximo a R$50
        if (valor > 50) {
            valor = 50;
        }

        valor *= taxa;

        atualizarTiquete(tiquete);
        return valor;
    }

    public int calcularTempo(LocalTime horarioDeEntrada, LocalTime horarioDeSaida) {
        return (int) ChronoUnit.MINUTES.between(horarioDeEntrada, horarioDeSaida);
    }

    public List<Tiquete> obterTodosTiquetesDoBD() {
        List<Tiquete> listaTiquetes = new ArrayList<>();
        String sql = "SELECT * FROM Tiquete";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Tiquete tiquete = mapearTiquete(rs);
                listaTiquetes.add(tiquete);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter todos os tiquetes: " + e.getMessage());
        }

        return listaTiquetes;
    }

    public List<RankingCliente> obterRankingClientes() {
        List<RankingCliente> rankingClientes = new ArrayList<>();
        String sql = "SELECT cliente, SUM(valor) AS totalValor, COUNT(*) AS utilizacoes FROM Tiquete GROUP BY cliente";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nomeCliente = rs.getString("cliente");
                float totalValor = rs.getFloat("totalValor");
                int utilizacoes = rs.getInt("utilizacoes");
                rankingClientes.add(new RankingCliente(nomeCliente, totalValor, utilizacoes));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter ranking de clientes: " + e.getMessage());
        }

        return rankingClientes;
    }

    public ReceitaEstacionamento obterReceitaPorEstacionamento(int idEstacionamento) {
        String sql = "SELECT SUM(valor) AS total_receita, COUNT(*) AS quantidade_tiquetes "
                + "FROM tiquete WHERE id_estacionamento = ?";
        try (Connection conn = BancoDados.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEstacionamento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    float totalReceita = rs.getFloat("total_receita");
                    int quantidadeTiquetes = rs.getInt("quantidade_tiquetes");
                    return new ReceitaEstacionamento(totalReceita, quantidadeTiquetes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RankingTipoDeVaga> obterRankingPorTipoDeVaga() {
        List<RankingTipoDeVaga> rankingTiposDeVaga = new ArrayList<>();
        String sql = "SELECT tipoDeVaga, SUM(valor) AS totalValor, COUNT(*) AS utilizacoes FROM Tiquete GROUP BY tipoDeVaga";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String tipoDeVaga = rs.getString("tipoDeVaga");
                float totalValor = rs.getFloat("totalValor");
                int utilizacoes = rs.getInt("utilizacoes");
                rankingTiposDeVaga.add(new RankingTipoDeVaga(tipoDeVaga, totalValor, utilizacoes));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter ranking por tipo de vaga: " + e.getMessage());
        }

        return rankingTiposDeVaga;
    }

    public List<ReceitasMesEstacionamento> obterReceitaPorEstacionamentoEDatas(int idEstacionamento, LocalDate dataInicio, LocalDate dataFim) {
        List<ReceitasMesEstacionamento> receitas = new ArrayList<>();
        String sql = "SELECT DATE(data) AS data, SUM(valor) AS totalReceita "
                + "FROM Tiquete "
                + "WHERE ID_Estacionamento = ? AND data BETWEEN ? AND ? AND status = false "
                + "GROUP BY DATE(data)";

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEstacionamento);
            ps.setDate(2, java.sql.Date.valueOf(dataInicio));
            ps.setDate(3, java.sql.Date.valueOf(dataFim));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate data = rs.getDate("data").toLocalDate();
                    float totalReceita = rs.getFloat("totalReceita");
                    receitas.add(new ReceitasMesEstacionamento(idEstacionamento, data, totalReceita));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter receita por estacionamento e datas: " + e.getMessage());
        }
        return receitas;
    }

    public List<Tiquete> obterHistoricoPorCliente(String nomeCliente) {
        List<Tiquete> historico = new ArrayList<>();
        String sql = "SELECT * FROM Tiquete WHERE cliente = ? ORDER BY data DESC"; 

        try (Connection conn = BancoDados.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomeCliente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Tiquete tiquete = mapearTiquete(rs);
                    historico.add(tiquete);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter histórico de tíquetes para o cliente: " + e.getMessage());
        }

        return historico;
    }
}
