/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.GrupoProduto;
import ClashFlowObjeto.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import utilitario.DataUtil;

/**
 *
 * @author Sonia
 */
public class GrupoProdutoModel  extends AbstractTableModel{
    
    
    private List<GrupoProduto> grupoProdutos;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód. Grupo", "Descrição", "Data Cadastro"};

    public GrupoProdutoModel() {
        this.grupoProdutos = new ArrayList<>();
    }
    
    public GrupoProdutoModel(List<GrupoProduto> grupoProdutos) {
        this.grupoProdutos = grupoProdutos;
    }
    
    @Override
    public int getRowCount() {
        return grupoProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    GrupoProduto grupoProduto = grupoProdutos.get(rowIndex);
 
    switch (columnIndex) {
    case 0:
        return grupoProduto.getIdGrupoProduto();
    case 1:
        return grupoProduto.getDescricaoGrupo();
    case 2:
        return DataUtil.formatDate(grupoProduto.getDataCadastro());
   
    default:
        // Não deve ocorrer, pois só existem 4 colunas
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
}
    //sobrecarga do metodo  que esta na herança, e por ele podemos renomear as colunas
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
}


