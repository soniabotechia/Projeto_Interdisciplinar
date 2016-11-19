/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowObjeto;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Sonia
 */
public class Caixa {
    
    private int idCaixa;
    private Calendar dataAbertura;
    private double valorAbertura;
    private double valorFechamento;
    private Calendar dataFechamento;
    private List<LancamentosCaixa> listaLancamento;

    public List<LancamentosCaixa> getListaLancamento() {
        return listaLancamento;
    }

    public void setListaLancamento(List<LancamentosCaixa> listaLancamento) {
        this.listaLancamento = listaLancamento;
    }
    
    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    
    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
    
    public double getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public double getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(double valorFechamento) {
        this.valorFechamento = valorFechamento;
    }
    
    
    
}
