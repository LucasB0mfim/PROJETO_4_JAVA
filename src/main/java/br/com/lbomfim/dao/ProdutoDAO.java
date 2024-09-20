package br.com.lbomfim.dao;

import br.com.lbomfim.dao.generic.GenericDAO;
import br.com.lbomfim.dao.generic.IGenericDAO;
import br.com.lbomfim.domain.Produto;

/**
 * @author Lucas Bomfim 
 */

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IGenericDAO<Produto, Long> {

	public ProdutoDAO() {
		super(Produto.class);
	}
}
