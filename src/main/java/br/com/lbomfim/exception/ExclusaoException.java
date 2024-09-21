package br.com.lbomfim.exception;

/**
 * @author Lucas Bomfim 
 */

@SuppressWarnings("serial")
public class ExclusaoException extends Exception {
	public ExclusaoException(String mensagem) {
		super(mensagem);
	}
}
