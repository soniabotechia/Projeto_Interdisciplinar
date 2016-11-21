/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.GrupoProduto;
import exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitario.Conexao;
import utilitario.DataUtil;

/**
 *
 * @author Sonia
 */
public class GrupoProdutoDAO {
    
    private static final Logger logger = Logger.getLogger(GrupoProdutoDAO.class.getName());
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void add(GrupoProduto gp) throws DAOException  {

		try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement("INSERT INTO GRUPOS_PRODUTOS(gpDescricaoGrupo, gpDataProduto) VALUES(?, now())", Statement.RETURN_GENERATED_KEYS);
               
                        ps.setString(1, gp.getDescricaoGrupo());
                        ps.execute();
                        
                        rs = ps.getGeneratedKeys();

                        if (rs.next()) {
                            gp.setIdGrupoProduto(rs.getInt(1));
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
    
    public List<GrupoProduto> buscarTodos()  {
       
		try 
                {
                        
			conn = new Conexao().conectar();
			st = conn.createStatement();
               
                        rs = st.executeQuery("SELECT * FROM GRUPOS_PRODUTOS");
                        
                        List<GrupoProduto> grupos = new ArrayList<>();
                 
                        while(rs.next()) {
                            GrupoProduto grupo = new GrupoProduto();
                            grupo.setIdGrupoProduto(rs.getInt("gpIdGrupoProduto"));
                            grupo.setDescricaoGrupo(rs.getString("gpDescricaoGrupo"));
                            grupo.setDataCadastro(DataUtil.parseDate(rs.getDate("gpDataProduto")));
                            grupos.add(grupo);
                        }
                       
                        return grupos;
                        
                }
                catch (SQLException e)
                {
                    logger.log(Level.SEVERE, "N\u00e3o foi possivel listar do banco {0}", e.getMessage());
                    return null;
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
      public void deletar(int idGrupoProduto) throws SQLException 
    {
        try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "DELETE FROM GRUPO_PRODUTOS WHERE gpIdGrupoProduto = ?");
               
                        ps.setLong(1, idGrupoProduto);
                        ps.execute();
                                                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel deletar no banco " + e.getMessage());
                }
                finally 
                {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("Nao foi possivel fechar o Statement");
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
					System.out.println("Não foi possivel fechar a conexao");
				}
			}
		}
    
    
    }

    
}
