/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowObjeto;

import java.util.Calendar;

/**
 *
 * @author Italo
 */
public class FormaPagamento {
    private int pagIdFormaPagamento;
    private String pagDescricaoPagamento;
    
    

    public int getPagIdFormaPagamento() {
        return pagIdFormaPagamento;
    }

    public void setPagIdFormaPagamento(int pagIdFormaPagamento) {
        this.pagIdFormaPagamento = pagIdFormaPagamento;
    }

    public String getPagDescricaoPagamento() {
        return pagDescricaoPagamento;
    }

    public void setPagDescricaoPagamento(String pagDescricaoPagamento) {
        this.pagDescricaoPagamento = pagDescricaoPagamento;
    }

     @Override
    public String toString() {
        return pagDescricaoPagamento;
    }
    
      @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.pagIdFormaPagamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormaPagamento other = (FormaPagamento) obj;
        if (this.pagIdFormaPagamento != other.pagIdFormaPagamento) {
            return false;
        }
        return true;
    }
}
