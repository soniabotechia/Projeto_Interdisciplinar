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
public class GrupoProduto {
    
    private int idGrupoProduto;
    private String DescricaoGrupo;
    private Calendar dataCadastro;

     public GrupoProduto(int idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }
     public GrupoProduto(){
    
    }
    public int getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(int idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public String getDescricaoGrupo() {
        return DescricaoGrupo;
    }

    public void setDescricaoGrupo(String DescricaoGrupo) {
        this.DescricaoGrupo = DescricaoGrupo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return DescricaoGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idGrupoProduto;
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
        final GrupoProduto other = (GrupoProduto) obj;
        if (this.idGrupoProduto != other.idGrupoProduto) {
            return false;
        }
        return true;
    }
    
    
   
}
