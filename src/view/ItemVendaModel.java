/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.ItemVenda;
import ClashFlowObjeto.Produto;
import ClashFlowObjeto.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Sonia
 */
public class ItemVendaModel extends AbstractTableModel {
    
    private List<ItemVenda> itens;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód. Produto", "Produto", "Quantidade", "Preço Unitário", "Local", "Preço Total"};

    public ItemVendaModel() {
        this.itens = new ArrayList<>();
    }
    
    public ItemVendaModel(List<ItemVenda> produtos) {
        this.itens = produtos;
    }
 
    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    ItemVenda item = itens.get(rowIndex);
 
        switch (columnIndex) {
        case 0:
            return item.getProduto().getCodigoProduto();
        case 1:
            return item.getProduto().getDescricaoProduto();
        case 2:
            return item.getQuantidade();
        case 3:
            return item.getProduto().getPrecoVenda();
        case 4:
            return item.getProduto().getLocal();
        case 5:
            return (item.getQuantidade()*(item.getProduto().getPrecoVenda()));
        default:
            // Não deve ocorrer, pois só existem 4 colunas
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public ItemVenda getValueAt(int rowIndex) {
        return itens.get(rowIndex);
    }

}
