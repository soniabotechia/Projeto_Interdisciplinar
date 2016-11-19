/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.CaixaDAO;
import ClashFlowDAO.LancamentosCaixaDAO;
import ClashFlowObjeto.Caixa;
import ClashFlowObjeto.LancamentosCaixa;
import exception.DAOException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia
 */
public class CaixaBO {
    
    private CaixaDAO caixaDAO;
    private LancamentosCaixaDAO lancamentosCaixaDAO;
    private double valorFechamento; 
    
    public CaixaBO()
    {
        caixaDAO = new CaixaDAO();
        lancamentosCaixaDAO = new LancamentosCaixaDAO();
    }
    
    public void aberturaCaixa(Caixa cx) throws DAOException
    {
        
        if(caixaDAO.buscarCaixaAberto() != null){
            JOptionPane.showMessageDialog(null,"Já existe um caixa aberto") ;
        }
        else{
            caixaDAO.abertura(cx);
            JOptionPane.showMessageDialog(null,"Caixa aberto com sucesso");

        }
    }     
    
    public Caixa buscarCaixaAberto() throws DAOException {
        return caixaDAO.buscarCaixaAberto();
    }
    
    public Double fechamentoCaixa() throws DAOException{
        Caixa caixa = new Caixa();
        CaixaDAO caixaDAO = new CaixaDAO();
        
        caixa.setListaLancamento(lancamentosCaixaDAO.buscarTodosCaixaAberto());
        
        
        for(LancamentosCaixa lc : caixa.getListaLancamento()) {
            
            if(lc.getTipoMovimento().isCredito()){
                valorFechamento += lc.getValorMovimento();
            }
            else{
                valorFechamento -= lc.getValorMovimento();
            }
        }
        
        caixa.setValorFechamento(valorFechamento);
        caixaDAO.atualizaFechamento(caixa);
        return valorFechamento;
   }
}
