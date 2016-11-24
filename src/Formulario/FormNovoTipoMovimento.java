/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;


import CashFlowBO.TipoMovimentoBO;
import ClashFlowObjeto.TipoMovimento;
import exception.DAOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Caio Henrique
 */
public class FormNovoTipoMovimento extends javax.swing.JFrame {
   private CallbackForm<TipoMovimento> callbackForm;
  
   public FormNovoTipoMovimento()
    {
        this(null);
    }
     public FormNovoTipoMovimento(CallbackForm<TipoMovimento> callbackForm)
    {
        init(callbackForm);
    }
    
    private void init (CallbackForm<TipoMovimento> callbackForm) {
        initComponents();
        this.callbackForm = callbackForm;
        this.labelError.setVisible(false);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        btnSalvarNovoMovimento = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDescNovoMovimento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCredito = new javax.swing.JRadioButton();
        btnDebito = new javax.swing.JRadioButton();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSalvarNovoMovimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarNovoMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnSalvar.png"))); // NOI18N
        btnSalvarNovoMovimento.setText("Salvar");
        btnSalvarNovoMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarNovoMovimentoActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnSair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Tipo de Movimento ");

        txtDescNovoMovimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        buttonGroup3.add(btnCredito);
        btnCredito.setText("Crédito");

        buttonGroup3.add(btnDebito);
        btnDebito.setText("Débito");
        btnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebitoActionPerformed(evt);
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
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalvarNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(btnCredito)
                .addGap(72, 72, 72)
                .addComponent(btnDebito)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredito)
                    .addComponent(btnDebito))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarNovoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarNovoMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarNovoMovimentoActionPerformed
        hideError();
        int aux=0;
        TipoMovimento tm = new TipoMovimento();
        tm.setDescricaoMovimento(txtDescNovoMovimento.getText());
        tm.setCredito(btnCredito.isSelected());
        tm.setDebito(btnDebito.isSelected());
        
        aux= validacao(evt);
        
        if(aux == 0){
            TipoMovimentoBO tmBO;
            tmBO = new TipoMovimentoBO();
       // try{
       
            tmBO.salvar(tm);
            JOptionPane.showMessageDialog(null,"Novo movimento salvo com sucesso!");
            
            if(callbackForm !=null)
           {
               callbackForm.fim(tm);
               
           }
           btnSairActionPerformed(evt);
        
         /*catch(DAOException ex)
        {
            showError(ex.getMessage());
        }*/
        }
    
       
    }//GEN-LAST:event_btnSalvarNovoMovimentoActionPerformed
    private int validacao(java.awt.event.ActionEvent evt)
    {
        int erro =0;
         if(txtDescNovoMovimento.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Erro.Campo descrição vazio!");
            erro++;
        }
        if(!btnCredito.isSelected() && !btnDebito.isSelected())
        {
             JOptionPane.showMessageDialog(null,"Selecione crédito ou débito!");
             erro++;
        }
        return erro;
     }
      private void hideError()
    {
        this.labelError.setText("");
        this.labelError.setVisible(false);
    }
     private void showError(String texto)
    {
        this.labelError.setText(texto);
        this.labelError.setVisible(true);
    }
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose(); //Comando utilizado para encerrar o formulário sem encerrar a aplicação.
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDebitoActionPerformed

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
            java.util.logging.Logger.getLogger(FormNovoTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNovoTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNovoTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNovoTipoMovimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNovoTipoMovimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnCredito;
    private javax.swing.JRadioButton btnDebito;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarNovoMovimento;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelError;
    private javax.swing.JTextField txtDescNovoMovimento;
    // End of variables declaration//GEN-END:variables
}
