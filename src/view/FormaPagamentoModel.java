/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import ClashFlowObjeto.FormaPagamento;

import java.util.ArrayList;
import java.util.List;
import javax.sql.RowSetListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sonia
 */
public class FormaPagamentoModel  extends AbstractTableModel{
    
    
    private List<FormaPagamento> formaPagamentos;
    // Array com os nomes das colunas. renomeando as colunas
    private final String[] colunas = new String[]{"Cód. Forma de Pag.", "Descrição"};

    public FormaPagamentoModel() {
        this.formaPagamentos = new ArrayList<>();
    }
    
    public FormaPagamentoModel(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = formaPagamentos;
    }
    
    //adiciona item na lista para leitura da tabela em tempo real
    public void addFormaPagamento(FormaPagamento formaPagamento){
        formaPagamentos.add(formaPagamento);
    }
            
   
    @Override
    public int getRowCount() {
        
        return formaPagamentos.size();
        
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         // Pega o produto referente a linha especificada.
    FormaPagamento formaPagamento = formaPagamentos.get(rowIndex);
    
       
    
    switch (columnIndex) {
    case 0:
        return formaPagamento.getPagIdFormaPagamento();
    case 1:
        return formaPagamento.getPagDescricaoPagamento();
  
   
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