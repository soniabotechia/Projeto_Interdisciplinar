/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.FormaPagamentoDAO;
import ClashFlowObjeto.FormaPagamento;
import exception.DAOException;
import java.util.List;

/**
 *
 * @author Italo
 */
public class FormaPagamentoBO {
    FormaPagamentoDAO formaPagamentoDAO;
    
    public FormaPagamentoBO()
    {
        formaPagamentoDAO = new FormaPagamentoDAO();
    }
    
    public void salvar(FormaPagamento fp) throws DAOException
    {
        formaPagamentoDAO.add(fp);
    }
    
    public List<FormaPagamento> buscarTodos() {
        return formaPagamentoDAO.buscarTodos();
    }
}
