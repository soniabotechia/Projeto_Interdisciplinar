/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.CaixaDAO;
import ClashFlowObjeto.Caixa;
import exception.DAOException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia
 */
public class CaixaBO {
    
    CaixaDAO caixaDAO;
    
    public CaixaBO()
    {
        caixaDAO = new CaixaDAO();
    }
    
    public void aberturaCaixa(Caixa cx) throws DAOException
    {
        if(cx.getDataFechamento()== null){
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
    
}
