/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.TipoMovimentoDAO;
import ClashFlowObjeto.TipoMovimento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Caio Henrique
 */
public class TipoMovimentoBO 
{
    TipoMovimentoDAO  TipoMovimentoDAO;
    
    public TipoMovimentoBO()
    {
        TipoMovimentoDAO= new TipoMovimentoDAO();
    }
     
    public void salvar(TipoMovimento tm)
    {
        TipoMovimentoDAO.add(tm);
    }
   
     public List<TipoMovimento> buscarTodos()
    {
        return TipoMovimentoDAO.buscarTodos();
    }
     
    public void del(int idTipoMovimento) throws SQLException
    {
        TipoMovimentoDAO.deletar(idTipoMovimento);
    }
}
