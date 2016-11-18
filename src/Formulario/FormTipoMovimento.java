/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import CashFlowBO.TipoMovimentoBO;
import ClashFlowObjeto.TipoMovimento;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.TipoMovimentoModel;

/**
 *
 * @author Caio Henrique
 */
public class FormTipoMovimento extends javax.swing.JFrame {

     private static final Logger logger = Logger.getLogger(FormTipoMovimento.class.getName());
    /**
     * Creates new form FormTipoMovimento
     */
    public FormTipoMovimento() {
        initComponents();
    }
    private List<TipoMovimento> getTipoMovimento() {
    
        TipoMovimentoBO tipoMovimentoBO = new TipoMovimentoBO();
        return tipoMovimentoBO.buscarTodos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNovoMovimento = new javax.swing.JButton();
        btnAlterarMovimento = new javax.swing.JButton();
        btnExcluirMovimento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtTipoMovimento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        jLabel1.setText("Tipo de Movimento");

        btnNovoMovimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnNovo.png"))); // NOI18N
        btnNovoMovimento.setText("Novo");
        btnNovoMovimento.setPreferredSize(new java.awt.Dimension(60, 60));
        btnNovoMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoMovimentoActionPerformed(evt);
            }
        });

        btnAlterarMovimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAlterarMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnAlterar.png"))); // NOI18N
        btnAlterarMovimento.setText("Alterar");
        btnAlterarMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarMovimentoActionPerformed(evt);
            }
        });

        btnExcluirMovimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluirMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnExcluir.png"))); // NOI18N
        btnExcluirMovimento.setText("Excluir");
        btnExcluirMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMovimentoActionPerformed(evt);
            }
        });

        JtTipoMovimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JtTipoMovimento.setModel(new TipoMovimentoModel(getTipoMovimento()));
        JtTipoMovimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(JtTipoMovimento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluirMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoMovimentoActionPerformed
       formNovoTipoMovimento = new FormNovoTipoMovimento(this.callbackTP());
       formNovoTipoMovimento.setVisible(true);

    }//GEN-LAST:event_btnNovoMovimentoActionPerformed

    private CallbackForm callbackTP(){
        return new CallbackForm<TipoMovimento>(){
             @Override       
             public void fim(TipoMovimento tipoMovimento){
                formNovoTipoMovimento.setVisible(false);
                formNovoTipoMovimento = null;// limpando a memoria
                //jogando dentro da variavel o TbModel para ser manipulado
                TipoMovimentoModel tipoMovimentoModel = (TipoMovimentoModel) JtTipoMovimento.getModel();
                tipoMovimentoModel.addTipoMovimento(tipoMovimento);
                tipoMovimentoModel.fireTableDataChanged();
            }                
        };
    }
    private void btnAlterarMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarMovimentoActionPerformed
        FormAlterarProduto formAltPro = new FormAlterarProduto();
        formAltPro.setVisible(true);
    }//GEN-LAST:event_btnAlterarMovimentoActionPerformed

    private void btnExcluirMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMovimentoActionPerformed
        
        TipoMovimentoBO tipoMovimentoBO = new TipoMovimentoBO();
        int row = JtTipoMovimento.getSelectedRow();
        TipoMovimento tipoMovimento = ((TipoMovimentoModel) JtTipoMovimento.getModel()).getValueAt(row);
        try {
            tipoMovimentoBO.del(tipoMovimento.getIdTipoMovimento());
            TipoMovimentoModel tipoMovimentoModel = (TipoMovimentoModel) JtTipoMovimento.getModel();
            tipoMovimentoModel.delTipoMovimento(tipoMovimento);
            tipoMovimentoModel.fireTableDataChanged();
            JOptionPane.showMessageDialog(null,"Item deletado com sucesso") ;
        } catch (SQLException ex) {
            Logger.getLogger(FormTipoMovimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirMovimentoActionPerformed

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
            java.util.logging.Logger.getLogger(FormTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTipoMovimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtTipoMovimento;
    private javax.swing.JButton btnAlterarMovimento;
    private javax.swing.JButton btnExcluirMovimento;
    private javax.swing.JButton btnNovoMovimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private FormNovoTipoMovimento formNovoTipoMovimento;
}
