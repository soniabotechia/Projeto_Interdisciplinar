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
 * @author Italo Molina
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
        
        logado = usuarioDAO.logarUsu(u);
           
        return logado;
    }
}
