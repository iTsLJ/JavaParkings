/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
//import controller.*; 

import javax.swing.JButton;


/**
 *
 * @author mateu
 */
public class menuView extends javax.swing.JFrame {

    /**
     * Creates new form menuVilw
     */
    public menuView() {
        initComponents();
    }
    public JButton getbntAddEstacionamento() {
        return bntAddEstacionamento;
    }
    public JButton getbntAddCliente() {
        return bntAddCliente;
    }
    public JButton getbntAddTiquete() {
        return bntAddTiquete;
    }
    public JButton getbntAddVeiculo() {
        return bntAddVeiculo;
    }
    public JButton getbntFinalisarTiquete() {
        return bntFinalisarTiquete;
    }
    public JButton getbntSair() {
        return bntSair;
    }
    public JButton getbntVisualisarCliente() {
        return bntVisualisarCliente;
    }
    public JButton getbntVisualisarEstacionamneto() {
        return bntVisualisarEstacionamneto;
    }
    public JButton getbntVisualisarTiquete() {
        return bntVisualisarTiquete;
    }
    
    public JButton getbntRelatorios(){
        return bntRelatorios;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        bntAddEstacionamento = new javax.swing.JButton();
        bntAddCliente = new javax.swing.JButton();
        bntAddVeiculo = new javax.swing.JButton();
        bntAddTiquete = new javax.swing.JButton();
        bntFinalisarTiquete = new javax.swing.JButton();
        bntVisualisarEstacionamneto = new javax.swing.JButton();
        bntVisualisarCliente = new javax.swing.JButton();
        bntVisualisarTiquete = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        bntRelatorios = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escolha uma das Opções ");

        bntAddEstacionamento.setText("Add  estacionamento ");
        bntAddEstacionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddEstacionamentoActionPerformed(evt);
            }
        });

        bntAddCliente.setText("Add cliente");
        bntAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddClienteActionPerformed(evt);
            }
        });

        bntAddVeiculo.setText("Add Veiculo");
        bntAddVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddVeiculoActionPerformed(evt);
            }
        });

        bntAddTiquete.setBackground(new java.awt.Color(204, 255, 204));
        bntAddTiquete.setText("Iniciar um Ticket");
        bntAddTiquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddTiqueteActionPerformed(evt);
            }
        });

        bntFinalisarTiquete.setBackground(new java.awt.Color(255, 102, 102));
        bntFinalisarTiquete.setText("Finalizar um Ticket");
        bntFinalisarTiquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFinalisarTiqueteActionPerformed(evt);
            }
        });

        bntVisualisarEstacionamneto.setText("Visualizar um Estacionamneto");
        bntVisualisarEstacionamneto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVisualisarEstacionamnetoActionPerformed(evt);
            }
        });

        bntVisualisarCliente.setText("Visualizar um Cliente");
        bntVisualisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVisualisarClienteActionPerformed(evt);
            }
        });

        bntVisualisarTiquete.setText("Visualizar Tickets");
        bntVisualisarTiquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVisualisarTiqueteActionPerformed(evt);
            }
        });

        bntSair.setBackground(new java.awt.Color(255, 51, 51));
        bntSair.setText("Sair ");
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });

        bntRelatorios.setText("Relatorios");
        bntRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRelatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bntAddCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntAddEstacionamento, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(bntAddVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntAddTiquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bntVisualisarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntVisualisarEstacionamneto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntVisualisarTiquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntFinalisarTiquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(bntRelatorios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAddEstacionamento)
                    .addComponent(bntVisualisarEstacionamneto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAddCliente)
                    .addComponent(bntVisualisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAddVeiculo)
                    .addComponent(bntVisualisarTiquete))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntFinalisarTiquete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntAddTiquete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bntRelatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(bntSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAddEstacionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddEstacionamentoActionPerformed
        new AddEstacionamentoView(); 
    }//GEN-LAST:event_bntAddEstacionamentoActionPerformed

    private void bntAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAddClienteActionPerformed

    private void bntAddVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAddVeiculoActionPerformed

    private void bntAddTiqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddTiqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAddTiqueteActionPerformed

    private void bntFinalisarTiqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFinalisarTiqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntFinalisarTiqueteActionPerformed

    private void bntVisualisarEstacionamnetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVisualisarEstacionamnetoActionPerformed
        new VerEstacionamentoView(); 
    }//GEN-LAST:event_bntVisualisarEstacionamnetoActionPerformed

    private void bntVisualisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVisualisarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntVisualisarClienteActionPerformed

    private void bntVisualisarTiqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVisualisarTiqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntVisualisarTiqueteActionPerformed

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSairActionPerformed

    private void bntRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRelatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntRelatoriosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAddCliente;
    private javax.swing.JButton bntAddEstacionamento;
    private javax.swing.JButton bntAddTiquete;
    private javax.swing.JButton bntAddVeiculo;
    private javax.swing.JButton bntFinalisarTiquete;
    private javax.swing.JButton bntRelatorios;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton bntVisualisarCliente;
    private javax.swing.JButton bntVisualisarEstacionamneto;
    private javax.swing.JButton bntVisualisarTiquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
