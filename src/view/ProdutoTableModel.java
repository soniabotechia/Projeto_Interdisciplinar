/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sonia
 */
public class ProdutoTableModel extends AbstractTableModel {
    
    private List<Produto> produtos;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód. Produto", "Produto", "Quantidade", "Preço Unitário", "Local"};

    public ProdutoTableModel() {
        this.produtos = new ArrayList<>();
    }
    
    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto produto){
       produtos.add(produto);
    }
    public void delProduto(Produto produto){
     produtos.remove(produto);
    
    }
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    Produto produto = produtos.get(rowIndex);
 
    switch (columnIndex) {
    case 0:
        return produto.getCodigoProduto();
    case 1:
        return produto.getDescricaoProduto();
    case 2:
        return produto.getEstoque();
    case 3:
        return produto.getPrecoVenda();
    case 4:
        return produto.getLocal();
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
    
    public Produto getValueAt(int rowIndex) {
        return produtos.get(rowIndex);
    }
    
}
