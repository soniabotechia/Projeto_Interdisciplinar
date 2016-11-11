/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.LancamentosCaixaDAO;
import ClashFlowObjeto.Caixa;
import ClashFlowObjeto.LancamentosCaixa; 
import exception.CaixaFechadoException;
import exception.DAOException;
import java.util.List;

/**
 *
 * @author Sonia
 */
public class LancamentosCaixaBO {
    
    private LancamentosCaixaDAO lancamentosCaixaDAO;
    private CaixaBO caixaBO;
    
    public LancamentosCaixaBO()
    {
        lancamentosCaixaDAO = new LancamentosCaixaDAO();
        caixaBO = new CaixaBO();
    }
    
    public void salvar(LancamentosCaixa lc) throws CaixaFechadoException, DAOException
    {
        Caixa caixa = caixaBO.buscarCaixaAberto();
        
        if(caixa == null) {
            throw new CaixaFechadoException();
        }
        
        lc.setCaixa(caixa);
        lancamentosCaixaDAO.add(lc);
        
    }
    
    public List<LancamentosCaixa> buscarTodos() {
        return lancamentosCaixaDAO.buscarTodos();
    }
}
