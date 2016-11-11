/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.VendaDAO;
import ClashFlowObjeto.Venda;

/**
 *
 * @author Sonia
 */
public class VendaBO {
    
    VendaDAO vendaDAO;
    
    public VendaBO()
    {
       vendaDAO = new VendaDAO();
    }
    
    public void novaVenda(Venda v)
    {
        vendaDAO.novaVenda(v);
    }
}
