package br.com.lbomfim.dao.generic;

import java.util.Collection;

/**
 * @author Lucas Bomfim 
 */

public interface IGenericDAO<T> {
	public T cadastrar(T entity) throws Exception;
	public T atualizar(T entity) throws Exception;
	public Collection<T> buscarTodos() throws Exception;
	public void excluir(T entity) throws Exception;
}
