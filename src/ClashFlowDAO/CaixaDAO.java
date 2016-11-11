/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.Caixa;

import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitario.Conexao;
import utilitario.DataUtil;

/**
 *
 * @author Sonia
 */
public class CaixaDAO {
    
     private static final Logger logger = Logger.getLogger(CaixaDAO.class.getName());
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void abertura(Caixa cx) throws DAOException  {

		try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement("INSERT INTO CAIXA (cxDataAbertura, cxValorAbertura, cxValorFechamento) VALUES(now(), ?,?)", Statement.RETURN_GENERATED_KEYS);
               
                        ps.setDouble(1, cx.getValorAbertura());
                        ps.setDouble(2, cx.getValorFechamento());
                        ps.execute();
                        
                        rs = ps.getGeneratedKeys();

                        if (rs.next()) {
                            cx.setIdCaixa(rs.getInt(1));
                        }
       
                        
                }
                catch (SQLException e)
                {
                    logger.log(Level.SEVERE, "N\u00e3o foi possivel salvar no banco {0}", e.getMessage());
                    throw new DAOException("Não foi possivel salvar no banco");
                }
                finally 
                {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					logger.severe("Nao foi possivel fechar o Statement");
				}
			}
			if (conn != null) 
                        {
				try 
                                {
					conn.close();
                                }                                 
                                catch (SQLException e)
                                {
					logger.severe("Não foi possivel fechar a conexao");
				}
			}
		}
    }
    
    public Caixa buscarCaixaAberto() throws DAOException {
    

         try {
            conn = new Conexao().conectar();
            st = conn.createStatement();
             rs = st.executeQuery("Select * from caixa c Where c.cxDataFechamento is null");
             
             Caixa caixa = null;
             
             while(rs.next()) {
                 caixa = new Caixa();
                 caixa.setIdCaixa(rs.getInt("cxIdCaixa"));
                 caixa.setDataCadastro(DataUtil.parseDate(rs.getDate("cxDataAbertura")));
                 caixa.setValorAbertura(rs.getDouble("cxValorAbertura"));
             }
             
             return caixa;
             
             
         } catch (SQLException ex) {
             logger.log(Level.SEVERE, "N\u00e3o foi consultar o caixa aberto {0}", ex.getMessage());
             throw new DAOException("Não foi possivel consultar o caixa aberto");
         }     finally 
                {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					logger.severe("Nao foi possivel fechar o Statement");
				}
			}
			if (conn != null) 
                        {
				try 
                                {
					conn.close();
                                }                                 
                                catch (SQLException e)
                                {
					logger.severe("Não foi possivel fechar a conexao");
				}
			}
		}
    
    }
    
}
