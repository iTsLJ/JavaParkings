/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author nanda
 */
public class ReceitaMesEstacionamentoView extends javax.swing.JFrame {

    private JFormattedTextField jFormattedDataInicio;
    private JFormattedTextField jFormattedDataFim;

    public ReceitaMesEstacionamentoView() {
        initComponents();
        configDataInicio();
        configDataFim();
    }

    public JButton getBtnConfirmar() {
        return this.btnConfirmar;
    }

    public JButton getBtnVisualizar() {
        return this.btnVisualizar;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public JTextPane getjTextFim() {
        return jTextFim;
    }

    public JTextPane getjTextPaneInicio() {
        return jTextPaneInicio;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public JFormattedTextField getjFormattedDataInicio() {
        return jFormattedDataInicio;
    }
    
    public JFormattedTextField getjFormattedDataFim() {
        return jFormattedDataFim;
    }

    private void configDataInicio() {
        try {
            // Configuração da máscara no formato de data
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_'); // Define o caractere de preenchimento como '_'
            maskFormatter.setValidCharacters("0123456789");

            // Cria um JFormattedTextField com a máscara
            jFormattedDataInicio= new JFormattedTextField(maskFormatter);

            // Substitui o componente existente pelo JFormattedTextField
            jScrollPane1.setViewportView(jFormattedDataInicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void configDataFim() {
        try {
            // Configuração da máscara no formato de data
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_'); // Define o caractere de preenchimento como '_'
            maskFormatter.setValidCharacters("0123456789"); // Permitindo apenas números
            // Cria um JFormattedTextField com a máscara
            jFormattedDataFim = new JFormattedTextField(maskFormatter);

            // Substitui o componente existente pelo JFormattedTextField
            jScrollPane3.setViewportView(jFormattedDataFim);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    public void configDara() {
//        try {
//            // Criando e aplicando a máscara para ambos os campos
//            MaskFormatter dateMask = new MaskFormatter("##/##/####");
//            dateMask.setPlaceholderCharacter('_'); // Usando "_" como caractere de preenchimento
//            dateMask.setValidCharacters("0123456789"); // Permitindo apenas números
//            dateMask.install(txtDataInicio); // Aplica a máscara à data de início
//            dateMask.install(txtDataFim); // Aplica a máscara à data de fim
//
//            // Ajustando a largura dos campos para acomodar as máscaras
//            txtDataInicio.setColumns(10);
//            txtDataFim.setColumns(10);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVisualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneInicio = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextFim = new javax.swing.JTextPane();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConfirmar.setBackground(new java.awt.Color(204, 255, 255));
        btnConfirmar.setText("Voltar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Digite o ID do Estacionamento que Deseja Visualizar:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID:");

        btnVisualizar.setBackground(new java.awt.Color(153, 255, 153));
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        jLabel5.setText("Data de inicio");

        jLabel6.setText("Data de fim");

        jScrollPane1.setViewportView(jTextPaneInicio);

        jScrollPane3.setViewportView(jTextFim);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnConfirmar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVisualizar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnVisualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVisualizarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceitaMesEstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceitaMesEstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceitaMesEstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceitaMesEstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceitaMesEstacionamentoView().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextPane jTextFim;
    private javax.swing.JTextPane jTextPaneInicio;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

}
