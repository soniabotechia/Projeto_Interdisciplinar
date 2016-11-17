/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.ItemVenda;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sonia
 */
public class ItemVendaDAO {
    
    private static final Logger logger = Logger.getLogger(ItemVendaDAO.class.getName());
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void add(ItemVenda item, Connection conn) throws DAOException
    {
    
        try {
            
            ps = conn.prepareStatement("Insert into ITEM_VENDA (prIdProduto, vdIdVenda, ivQuantidade) VALUES (?, ?, ?)");
            
            
                ps.setLong(1, item.getProduto().getCodigoProduto());
                ps.setLong(2, item.getVenda().getIdVenda());
                ps.setInt(3, item.getQuantidade());
                       
            ps.executeQuery();
            
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            throw new DAOException(ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Nao foi possivel fechar o Statement");
                }
            }
        }
    
    }
    
}
