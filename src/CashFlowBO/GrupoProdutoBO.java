/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.GrupoProdutoDAO;

import ClashFlowObjeto.GrupoProduto;
import exception.DAOException;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Sonia
 */
public class GrupoProdutoBO {
   
    GrupoProdutoDAO grupoProdutoDAO;
    
    public GrupoProdutoBO()
    {
        grupoProdutoDAO = new GrupoProdutoDAO();
    }
    
    public void salvar(GrupoProduto gp) throws DAOException
    {
        grupoProdutoDAO.add(gp);
    }
    
    public List<GrupoProduto> buscarTodos() {
        return grupoProdutoDAO.buscarTodos();
    }
    public void del(int idGrupoProduto) throws SQLException
    {
        grupoProdutoDAO.deletar(idGrupoProduto);
    }
    
}   
