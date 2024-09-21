package br.com.lbomfim.exception;

/**
 * @author Lucas Bomfim 
 */

@SuppressWarnings("serial")
public class ConsultaException extends Exception {
	public ConsultaException(String mensagem) {
		super(mensagem);
	}
}
