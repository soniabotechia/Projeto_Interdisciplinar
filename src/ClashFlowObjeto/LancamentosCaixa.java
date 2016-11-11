/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowObjeto;

import java.util.Calendar;

/**
 *
 * @author Sonia
 */
public class LancamentosCaixa {
    
    private int idlancamentoCaixa;
    private Calendar dataMovimento;
    private double valorMovimento;
    private String observacao;
    private FormaPagamento formaPagamento;
    private TipoMovimento tipoMovimento;
    private Caixa caixa;
    

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }
    
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdlancamentoCaixa() {
        return idlancamentoCaixa;
    }

    public void setIdlancamentoCaixa(int idlancamentoCaixa) {
        this.idlancamentoCaixa = idlancamentoCaixa;
    }
    
   
    public Calendar getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Calendar dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(double valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    
   
}
