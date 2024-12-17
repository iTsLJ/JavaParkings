package controller;

import com.mycompany.mavenproject1.Model.ReceitasMesEstacionamento;
import dao.Tiquetes;
import view.ReceitaMesEstacionamentoView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import view.RelatorisoMenuView;

public class ReceitaMesEstacionamentoController {

    private ReceitaMesEstacionamentoView view;

    public ReceitaMesEstacionamentoController(ReceitaMesEstacionamentoView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getBtnVisualizar().addActionListener(e -> btnVisualizarActionPerformed());
        view.getBtnConfirmar().addActionListener(e -> voltar());
    }

    public void voltar() {
        view.dispose();
        RelatorisoMenuView relatorisoMenuView = new RelatorisoMenuView();
        new RelatorisoMenuController();

    }

    private void btnVisualizarActionPerformed() {
        String idEstacionamentoStr = view.getTxtID().getText().trim();
        String dataInicioStr = view.getjFormattedDataInicio().getText().trim();
        String dataFimStr = view.getjFormattedDataFim().getText().trim();

        // Verificar se os campos de ID e datas estão preenchidos
        if (idEstacionamentoStr.isEmpty() || dataInicioStr.isEmpty() || dataFimStr.isEmpty()) {
            view.getjTextArea().setText("Por favor, preencha todos os campos!");
            return;
        }

        // Validar as datas
        if (!validarDatas(dataInicioStr, dataFimStr)) {
            return; // Se as datas não forem válidas, não prosseguir
        }

        int idEstacionamento = Integer.parseInt(idEstacionamentoStr);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date inicio = sdf.parse(dataInicioStr);
            Date fim = sdf.parse(dataFimStr);
            LocalDate dataInicio = inicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dataFim = fim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Obter as receitas
            List<ReceitasMesEstacionamento> receitas = Tiquetes.getInstance().obterReceitaPorEstacionamentoEDatas(idEstacionamento, dataInicio, dataFim);

            // Exibir as receitas
            StringBuilder resultado = new StringBuilder();
            float receitaTotal = 0;

            if (receitas.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nenhuma receita encontrada para o período informado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                for (ReceitasMesEstacionamento receita : receitas) {
                    resultado.append("Data: ").append(receita.getData())
                            .append(" - Total: R$").append(String.format("%.2f", receita.getTotalReceita()))
                            .append("\n");
                    receitaTotal += receita.getTotalReceita();
                }
                resultado.append("\nReceita Total no Período: R$").append(String.format("%.2f", receitaTotal));
            }
            view.getjTextArea().setText(resultado.toString());
        } catch (ParseException e) {
            view.getjTextArea().setText("Formato de data inválido! Use o formato DD/MM/AAAA.");
        }
    }

    private boolean validarDatas(String dataInicio, String dataFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date inicio = sdf.parse(dataInicio);
            Date fim = sdf.parse(dataFim);

            if (fim.before(inicio)) {
                view.getjTextArea().setText("A data de fim não pode ser anterior à data de início!");
                return false;
            }
            return true; // Datas válidas
        } catch (ParseException e) {
            view.getjTextArea().setText("Formato de data inválido! Use o formato DD/MM/AAAA.");
            return false;
        }
    }
}
