/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashFlowBO;

import ClashFlowDAO.UsuarioDAO;
import ClashFlowObjeto.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import utilitario.Conexao;

/**
 *
 * @author Italo
 */
public class UsuarioBO {
    UsuarioDAO usuarioDAO;
    private Connection conn;
    
    public UsuarioBO()
    {
        usuarioDAO = new UsuarioDAO();
    }
    
    public void salvar(Usuario usuario)
    {
        //String dataCadastro = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        //usuario.setDataCadastro(dataCadastro);
        usuario.setAtivo("1");
        usuario.setStatus("0");
        usuarioDAO.add(usuario);
    }
    
    public List<Usuario> buscarTodos() {
        return usuarioDAO.buscarTodos();
    }
    
    public int logarUsu(Usuario u){
        int logado = 0;
        
        String usuario = null;
        String senha = null;
        
        try {
            conn = new Conexao().conectar();
 
            //Executa a query de seleção
            java.sql.Statement st = conn.createStatement();
            st.executeQuery("select * from usuario where " +
                   " usuNome = '" + u.getUsuario() + "'" +
                   " and usuSenha = '" + u.getSenha() + "'");
            ResultSet rs = st.getResultSet();
 
            //Lista os alunos no console
            while (rs.next()) {
                usuario = rs.getString("usuNome");
                senha = rs.getString("usuSenha");
                
                System.out.print(usuario + " ");
                System.out.println(senha);
                
                if(usuario.equals(u.getUsuario()) && senha.equals(u.getSenha()))
                    logado = 1;
            }
           
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }//Fim try
        
        
                
        return logado;
    }
}
