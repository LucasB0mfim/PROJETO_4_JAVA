package br.com.lbomfim.exception;

/**
 * @author Lucas Bomfim 
 */

@SuppressWarnings("serial")
public class AtualizacaoException extends Exception {
	public AtualizacaoException(String mensagem) {
		super(mensagem);
	}
}
