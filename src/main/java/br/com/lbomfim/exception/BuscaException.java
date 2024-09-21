package br.com.lbomfim.exception;

/**
 * @author Lucas Bomfim 
 */

@SuppressWarnings("serial")
public class BuscaException extends Exception {
	public BuscaException(String mensagem) {
		super(mensagem);
	}

}
