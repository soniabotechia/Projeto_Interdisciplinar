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
        //verifica se existe caixa aberto e notifica usuario, senao abre novo caixa
        if(caixaDAO.buscarCaixaAberto() != null){
            JOptionPane.showMessageDialog(null,"Já existe um caixa aberto") ;
        }
        else{
            caixaDAO.abertura(cx);
            JOptionPane.showMessageDialog(null,"Caixa aberto com sucesso");

        }
    }     
    //chama funçao que verifica se o caixa esta aberto
    public Caixa buscarCaixaAberto() throws DAOException {
        return caixaDAO.buscarCaixaAberto();
    }
    
    public Double fechamentoCaixa(Caixa cx) throws DAOException{
        
        CaixaDAO caixaDAO = new CaixaDAO();
        
        cx.setListaLancamento(lancamentosCaixaDAO.buscarTodosCaixaAberto());
        valorFechamento = cx.getValorAbertura();
        System.out.println(valorFechamento);
        
        for(LancamentosCaixa lc : cx.getListaLancamento()) {
            
            if(lc.getTipoMovimento().isCredito()){
                valorFechamento += lc.getValorMovimento();
            }
            else{
                valorFechamento -= lc.getValorMovimento();
            }
        }
         
        cx.setValorFechamento( valorFechamento);
        caixaDAO.atualizaFechamento(cx);
        return ( valorFechamento );
   }
}
