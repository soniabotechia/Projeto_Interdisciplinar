/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.GrupoProduto;
import ClashFlowObjeto.TipoMovimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilitario.Conexao;

/**
 *
 * @author Caio Henrique
 */
public class TipoMovimentoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void add(TipoMovimento tm)  {

		try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "INSERT INTO tipo_movimento(tpmovDescricaoMovimento, tpmovcredito, tpmovdebito) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
               
                        ps.setString(1, tm.getDescricaoMovimento());
                        ps.setInt(2,tm.isCredito()? 1 : 0);
                        ps.setInt(3,tm.isDebito()? 1 : 0);
                        ps.execute();
                        
                        rs = ps.getGeneratedKeys();
                        
                        if (rs.next()) {
                            tm.setIdTipoMovimento(rs.getInt(1));
                        } 
                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel salvar no banco " + e.getMessage());
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
    public List<TipoMovimento> buscarTodos()  {
       
		try 
                {
                    
			conn = new Conexao().conectar();
			st = conn.createStatement();
               
                        rs = st.executeQuery("SELECT * FROM tipo_movimento");
                        
                        List<TipoMovimento> movimentos = new ArrayList<>();
                 
                        while(rs.next()) {
                            
                            TipoMovimento tm = new TipoMovimento();
                            tm.setIdTipoMovimento(rs.getInt("tpmovIdTipoMovimento"));
                            tm.setDescricaoMovimento(rs.getString("tpmovDescricaoMovimento"));
                            tm.setCredito((rs.getBoolean("tpmovcredito")));
                            tm.setDebito((rs.getBoolean("tpmovdebito")));
                            movimentos.add(tm);
                        }
                       
                        return movimentos;
                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel salvar no banco " + e.getMessage());
                    return null;
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
