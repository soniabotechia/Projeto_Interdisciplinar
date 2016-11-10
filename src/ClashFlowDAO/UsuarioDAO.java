/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowDAO;

import ClashFlowObjeto.Usuario;
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
public class UsuarioDAO {
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
        
    public void add(Usuario usuario)  {
                
		try 
                {
                        // String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			conn = new Conexao().conectar();
			ps = conn.prepareStatement( "INSERT INTO USUARIOS (usuNome, usuSenha, usuStatus, usuAtivo, usuDataCadastro) VALUES(?,?,?,?,now())");
               
                        ps.setString(1, usuario.getUsuario());
                        ps.setString(2, usuario.getSenha());
                        ps.setString(3, usuario.getStatus());
                        ps.setString(4, usuario.getAtivo());
                        ps.setString(5, usuario.getDataCadastro());
                        ps.execute();
                       
                        
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
				} 
                                catch (SQLException e)
                                {
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
    
     public List<Usuario> buscarTodos()  {
       
		try 
                {
                    
			conn = new Conexao().conectar();
			st = conn.createStatement();
               
                        rs = st.executeQuery("SELECT * FROM USUARIOS");
                        
                        List<Usuario> usuarios = new ArrayList<>();
                 
                        while(rs.next()) {
                            Usuario usuario = new Usuario();
                            usuario.setUsuario(rs.getString("usNome"));
                            usuario.setSenha(rs.getString("usSenha"));
                            
                            usuarios.add(usuario);
                        }
                        return usuarios;
                        
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