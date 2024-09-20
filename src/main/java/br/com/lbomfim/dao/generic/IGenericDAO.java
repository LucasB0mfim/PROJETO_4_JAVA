package br.com.lbomfim.dao.generic;

import java.util.Collection;

/**
 * @author Lucas Bomfim 
 */

public interface IGenericDAO<T, E> {
	public T cadastrar(T entity) throws Exception;
	public T atualizar(T entity) throws Exception;
	public Collection<T> buscarTodos() throws Exception;
	public T consultar(E valor) throws Exception;
	public void excluir(T entity) throws Exception;
}
