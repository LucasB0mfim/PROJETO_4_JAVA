package br.com.lbomfim.exception;

/**
 * @author Lucas Bomfim 
 */

@SuppressWarnings("serial")
public class CadastroException extends Exception {
	public CadastroException(String mensagem) {
		super(mensagem);
	}
}
