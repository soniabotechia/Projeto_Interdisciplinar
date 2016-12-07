/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

//import ClassesBO.VendasBO;
//import Objetos.Vendas;
import CashFlowBO.FormaPagamentoBO;
import CashFlowBO.VendaBO;
import ClashFlowObjeto.FormaPagamento;
import ClashFlowObjeto.ItemVenda;
import ClashFlowObjeto.LancamentosCaixa;
import ClashFlowObjeto.Produto;
import ClashFlowObjeto.Venda;
import exception.DAOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import view.ItemVendaModel;
import view.ProdutoTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
/**
 *
 * @author aluno
 */
public class FormNovaVenda extends javax.swing.JFrame {
    

    private static final Logger logger = Logger.getLogger(FormNovaVenda.class.getName());    
    private FormConsultaProduto Frm;
    private Produto produtoAtual;
    ArrayList<ItemVenda> listaItem = new ArrayList<ItemVenda>();
    double valorTotal=0;
    
    /**
     * Creates new form FormNovaVenda
     */
    public FormNovaVenda() {
        initComponents();
    }
    
    private FormaPagamento[] carregaFormas() {
        FormaPagamentoBO formaPagamentoBO = new FormaPagamentoBO();
        List<FormaPagamento> formas = formaPagamentoBO.buscarTodos();
        return formas.toArray(new FormaPagamento[formas.size()]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtQuantidadeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnFimVenda = new javax.swing.JButton();
        txtDescricaoProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        cBFormaPagamento = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTItemVenda = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnConsulta = new javax.swing.JButton();
        txtTroco = new JFormattedTextField(getFormatoMoeda());
        txtValorTotal = new JFormattedTextField(getFormatoMoeda());
        txtValorPago = new JFormattedTextField(getFormatoMoeda());
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CashFlow - Nova Venda");

        txtQuantidadeProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Código:");

        txtCodProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        btnFimVenda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFimVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnSalvar.png"))); // NOI18N
        btnFimVenda.setText("Finalizar Venda");
        btnFimVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFimVendaActionPerformed(evt);
            }
        });

        txtDescricaoProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Valor total:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Forma de Pagamento:");

        btnIncluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnIncluir.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        cBFormaPagamento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cBFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<FormaPagamento>(carregaFormas()));

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnExcluir.png"))); // NOI18N
        btnCancelar.setText("Cancelar Venda");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jTItemVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTItemVenda.setModel(new view.ItemVendaModel());
        jScrollPane2.setViewportView(jTItemVenda);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Troco:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Valor pago:");

        btnConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnConsulta.setText("Consulta Produtos");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        txtTroco.setText(null);
        txtTroco.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtValorTotal.setText(null);
        txtValorTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtValorPago.setText(null);
        txtValorPago.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorPagoFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setText("Nova Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDescricaoProduto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIncluir)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(417, 417, 417))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cBFormaPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFimVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cBFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFimVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void adicionaItem(){
         
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produtoAtual);
        itemVenda.setQuantidade(Integer.parseInt(txtQuantidadeProduto.getText()));
        //verificanddo estoque do item
        if(produtoAtual.getEstoque()>= itemVenda.getQuantidade()){
            listaItem.add(itemVenda);
            valorTotal += ((Integer.parseInt(txtQuantidadeProduto.getText())) * produtoAtual.getPrecoVenda());
            txtValorTotal.setText(String.valueOf(valorTotal));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Produto indicado não contém estoque!");
        }
    }     
   
    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if(txtQuantidadeProduto.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Insira a quantidade de produtos!");
        }
        else{
        adicionaItem();
        jTItemVenda.setModel(new ItemVendaModel(listaItem));
        jTItemVenda.repaint();
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        
        Frm = new FormConsultaProduto(getCallbackForm());
        Frm.setVisible(true);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void txtValorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorPagoFocusLost
       
        //replace troca a , por .
         txtTroco.setText(String.valueOf(Double.parseDouble(txtValorPago.getText().replace(",", ".")) - valorTotal));
                                      
    }//GEN-LAST:event_txtValorPagoFocusLost

    private void btnFimVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFimVendaActionPerformed
       
        Venda venda = new Venda();
        
        venda.setTotalVenda(Double.parseDouble(txtValorTotal.getText().replace(",", ".")));
        venda.setListaItem(listaItem);
        venda.setPagamento((FormaPagamento) cBFormaPagamento.getSelectedItem());
        
        VendaBO vendaBO = new VendaBO();
        
        try {
            vendaBO.novaVenda(venda);
        } catch (DAOException ex) {
            Logger.getLogger(FormNovaVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnFimVendaActionPerformed

    
    private CallbackForm<Produto> getCallbackForm() {
    
        return new CallbackForm<Produto>() {
            @Override
            public void fim(Produto p) {
                produtoAtual = p;
                txtCodProduto.setText(String.valueOf(p.getCodigoProduto()));
                txtDescricaoProduto.setText(p.getDescricaoProduto());
                Frm.setVisible(false);
                Frm = null;
            }
        };
        
    }
    
    private NumberFormatter getFormatoMoeda() {
        Locale locale = new Locale("pt", "BR");
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        dfs.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat(".##", dfs);
        NumberFormatter numberFormat = new NumberFormatter(decimalFormat);
        numberFormat.setFormat(decimalFormat);
        numberFormat.setAllowsInvalid(false);
        return numberFormat;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnFimVenda;
    private javax.swing.JButton btnIncluir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<FormaPagamento> cBFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTItemVenda;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JFormattedTextField txtTroco;
    private javax.swing.JFormattedTextField txtValorPago;
    private javax.swing.JFormattedTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables

   
}
