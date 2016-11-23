/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.FormaPagamento;
import exception.DAOException;
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
 * @author Italo
 */
public class FormaPagamentoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void add(FormaPagamento fp) throws DAOException  {

		try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "INSERT INTO FORMA_PAGAMENTO(pagDescricaoPagamento) VALUES(?)",Statement.RETURN_GENERATED_KEYS);
               
                        ps.setString(1, fp.getPagDescricaoPagamento());
                        
                        ps.execute();
                         rs = ps.getGeneratedKeys();
                         
                        if (rs.next()) {
                            fp.setPagIdFormaPagamento(rs.getInt(1));
                        } 
                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel salvar no banco " + e.getMessage());
                     throw new DAOException("Não foi possivel salvar no banco");
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
    
    public List<FormaPagamento> buscarTodos()  {
       
		try 
                {
                    
			conn = new Conexao().conectar();
			st = conn.createStatement();
               
                        rs = st.executeQuery("SELECT * FROM FORMA_PAGAMENTO");
                        
                        List<FormaPagamento> formas = new ArrayList<>();
                 
                        while(rs.next()) {
                            FormaPagamento formapag = new FormaPagamento();
                            formapag.setPagIdFormaPagamento(rs.getInt("pagIdFormaPagamento"));
                            formapag.setPagDescricaoPagamento(rs.getString("pagDescricaoPagamento"));
                            
                            
                            formas.add(formapag);
                        }
                       
                        return formas;
                        
                }
                catch (SQLException e)
                {
                    System.out.println("Não foi possivel listar do banco " + e.getMessage());
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
     public void deletar(int pagIdFormaPagamento) throws SQLException 
    {
        try 
                {
                    
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "DELETE FROM FORMA_PAGAMENTO WHERE pagIdFormaPagamento = ?");
               
                        ps.setLong(1, pagIdFormaPagamento);
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
