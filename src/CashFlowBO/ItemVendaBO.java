/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.ItemVendaDAO;
import ClashFlowObjeto.ItemVenda;
import exception.DAOException;
import java.util.List;

/**
 *
 * @author Sonia
 */
public class ItemVendaBO {
    
    ItemVendaDAO itemVendaDAO;
    
    public ItemVendaBO()
    {
       itemVendaDAO = new ItemVendaDAO();
    }
    
    public void itemVenda(List<ItemVenda> listaItem) throws DAOException
    {
       // itemVendaDAO.listaItens(listaItem);
    }
    
}
