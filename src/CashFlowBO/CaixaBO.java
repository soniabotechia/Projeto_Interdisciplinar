/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.CaixaDAO;
import ClashFlowObjeto.Caixa;
import exception.DAOException;

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
    
    public void AberturaCaixa(Caixa cx) throws DAOException
    {
        caixaDAO.abertura(cx);
    }
    
    public Caixa buscarCaixaAberto() throws DAOException {
        return caixaDAO.buscarCaixaAberto();
    }
    
}
