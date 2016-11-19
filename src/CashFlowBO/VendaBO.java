/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.ItemVendaDAO;
import ClashFlowDAO.LancamentosCaixaDAO;
import ClashFlowDAO.ProdutoDAO;
import ClashFlowDAO.VendaDAO;
import ClashFlowObjeto.Caixa;
import ClashFlowObjeto.ItemVenda;
import ClashFlowObjeto.LancamentosCaixa;
import ClashFlowObjeto.TipoMovimento;
import ClashFlowObjeto.Venda;
import exception.DAOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilitario.Conexao;

/**
 *
 * @author Sonia
 */
public class VendaBO {
    
    private static final Logger logger = Logger.getLogger(VendaBO.class.getName());
    
    private VendaDAO vendaDAO;
    private LancamentosCaixaDAO lancamentoCaixaDAO;
    private ItemVendaDAO itemVendaDAO;
    private CaixaBO caixaBO;
    private ProdutoDAO produtoDAO;
    
    
    public VendaBO()
    {
       vendaDAO = new VendaDAO();
       lancamentoCaixaDAO = new LancamentosCaixaDAO();
       itemVendaDAO = new ItemVendaDAO();
       caixaBO = new CaixaBO();
       produtoDAO = new ProdutoDAO();
    }
    
    public void novaVenda(Venda venda) throws DAOException
    {
        
        Caixa caixa = caixaBO.buscarCaixaAberto();
        if(caixa == null)
        {
             JOptionPane.showMessageDialog(null,"Caixa Fechado");
             return;
        }
        
             
        LancamentosCaixa lancamentoCaixa = new LancamentosCaixa();
                
        lancamentoCaixa.setValorMovimento(venda.getTotalVenda());
        lancamentoCaixa.setTipoMovimento(new TipoMovimento(5));
        lancamentoCaixa.setDataMovimento(Calendar.getInstance());
        lancamentoCaixa.setFormaPagamento(venda.getPagamento());
        lancamentoCaixa.setCaixa(caixa);
        lancamentoCaixa.setObservacao("Venda Balcao");
        venda.setLancamento(lancamentoCaixa);
        
        Connection conn = null;
        try {
            
            conn = Conexao.conectar();
            conn.setAutoCommit(false);
            
            lancamentoCaixaDAO.add(venda.getLancamento(), conn);
            vendaDAO.add(venda, conn);
           
            for(ItemVenda item : venda.getListaItem()) {
                produtoDAO.attEstoque(item.getProduto(), -item.getQuantidade(), conn);
                //pega cada item da lista de venda e seta um novo objeto ItemVenda
                item.setVenda(venda);
                //manda item a item pro DAO
                itemVendaDAO.add(item, conn);
                               
            }    
            JOptionPane.showMessageDialog(null,"Venda realizada!!");
            conn.commit();
            
        } catch(DAOException e) {
            System.out.println(e.getMessage());
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Não foi possivel efetuar o rollback", ex);
            }
            throw new DAOException("Não foi possivel salvar a venda");
        } catch (SQLException ex) {
            Logger.getLogger(VendaBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Não foi possivel fechar a conexao");
                }
            }

        }
        
    }
}
