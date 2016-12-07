/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.TipoMovimento;
import ClashFlowObjeto.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Caio Henrique
 */
public class UsuarioModel extends AbstractTableModel{
      private List<Usuario> usuarios;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód. de Usuário","Nome"};
    
     public UsuarioModel() {
        this.usuarios = new ArrayList<>();
    }
     
    public UsuarioModel(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    
     
     @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
   Usuario usuario = usuarios.get(rowIndex);
    
    switch (columnIndex) {
        
        case 0:
        return usuario.getIdusuario();
        case 1:
        return usuario.getUsuario();
        
   
    default:
        // Não deve ocorrer, pois só existem 2 colunas
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
}
    //sobrecarga do metodo  que esta na herança, e por ele podemos renomear as colunas
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Usuario getValueAt(int rowIndex) {
        return usuarios.get(rowIndex);
    }
    
    
}
