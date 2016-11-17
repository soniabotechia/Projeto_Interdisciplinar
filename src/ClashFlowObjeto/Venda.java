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
public class Venda {
    
    private int idVenda;
    private Calendar data;
    private int quantidade;
    private double totalVenda;
    private List<ItemVenda> ListaItem ;
    private FormaPagamento pagamento;
    private LancamentosCaixa lancamento;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public List<ItemVenda> getListaItem() {
        return ListaItem;
    }

    public void setListaItem(List<ItemVenda> ListaItem) {
        this.ListaItem = ListaItem;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public LancamentosCaixa getLancamento() {
        return lancamento;
    }

    public void setLancamento(LancamentosCaixa lancamento) {
        this.lancamento = lancamento;
    }

    
    
    
}
