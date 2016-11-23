/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ClashFlowObjeto.LancamentosCaixa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import utilitario.DataUtil;

/**
 *
 * @author Sonia
 */
public class FechamentoCaixaModel extends AbstractTableModel{

 
private List<LancamentosCaixa> tipoLancamentos;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Forma de Recebimento", "Valor Lançamento", "Tipo", "Data Lançamento"};
    
     public FechamentoCaixaModel() {
        this.tipoLancamentos= new ArrayList<>();
    }
     
     public FechamentoCaixaModel(List<LancamentosCaixa> tipoLancamentos) {
        this.tipoLancamentos = tipoLancamentos;
    }
     
     public void addLancamentoCaixa(LancamentosCaixa lancamentoCaixa){
     tipoLancamentos.add(lancamentoCaixa);
    }
     @Override
    public int getRowCount() {
        return tipoLancamentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    LancamentosCaixa tipoLanc = tipoLancamentos.get(rowIndex);
    
    switch (columnIndex) {
        
        case 0:
        return tipoLanc.getFormaPagamento().getPagDescricaoPagamento();
        case 1:
        return tipoLanc.getValorMovimento();
        case 2:
        return tipoLanc.getTipoMovimento().isCredito()? "Credito" : "Debito" ;    
        case 3:
        return DataUtil.formatDate(tipoLanc.getDataMovimento());
        
    default:
        // Não deve ocorrer, pois só existem 3 colunas
        throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
}
    //sobrecarga do metodo  que esta na herança, e por ele podemos renomear as colunas
     @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
