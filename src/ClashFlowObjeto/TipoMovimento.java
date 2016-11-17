/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashFlowObjeto;

/**
 *
 * @author Caio Henrique
 */
public class TipoMovimento {
    private int idTipoMovimento;
    private String descricaoMovimento;
    private boolean credito;
    private boolean debito; 

    public TipoMovimento(int idTipoMovimento) {
        this.idTipoMovimento = idTipoMovimento;
    }
    
    public TipoMovimento() {
        
    }
       
    public int getIdTipoMovimento() {
        return idTipoMovimento;
    }

    public void setIdTipoMovimento(int idTipoMovimento) {
        this.idTipoMovimento = idTipoMovimento;
    }

    public String getDescricaoMovimento() {
        return descricaoMovimento;
    }

    public void setDescricaoMovimento(String descricaoMovimento) {
        this.descricaoMovimento = descricaoMovimento;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }
    
    @Override
    public String toString() {
        return descricaoMovimento;
    }
}
