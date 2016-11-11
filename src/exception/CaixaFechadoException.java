/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Sonia
 */
public class CaixaFechadoException extends Exception {

    public CaixaFechadoException() {
        super("Caixa fechado! Favor abrir o caixa antes de lançar");
    }

    public CaixaFechadoException(String message) {
        super(message);
    }

    public CaixaFechadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaixaFechadoException(Throwable cause) {
        super(cause);
    }

    public CaixaFechadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
