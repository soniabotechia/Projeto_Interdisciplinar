/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.TipoMovimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Sonia
 */
public class TipoMovimentoModel extends AbstractTableModel{
    
    private List<TipoMovimento> tipoMovimentos;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód.do Movimento", "Movimento", "Descriçao do Tipo"};
    
     public TipoMovimentoModel() {
        this.tipoMovimentos = new ArrayList<>();
    }
     
     public TipoMovimentoModel(List<TipoMovimento> tipoMovimentos) {
        this.tipoMovimentos = tipoMovimentos;
    }
      public void addTipoMovimento(TipoMovimento tipomovimento){
        tipoMovimentos.add(tipomovimento);
    }
     
     @Override
    public int getRowCount() {
        return tipoMovimentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    TipoMovimento tipoMovimento = tipoMovimentos.get(rowIndex);
    
    switch (columnIndex) {
        
        case 0:
        return tipoMovimento.getIdTipoMovimento();
        case 1:
        return tipoMovimento.getDescricaoMovimento();
        case 2:
        if(tipoMovimento.isCredito() == true){
        
            return "credito";
        }else{
            return "Debito"  ;
        }
   
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
    
    
}
