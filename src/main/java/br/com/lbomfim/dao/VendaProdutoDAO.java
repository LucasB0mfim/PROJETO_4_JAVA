package br.com.lbomfim.dao;

import br.com.lbomfim.dao.generic.GenericDAO;
import br.com.lbomfim.dao.generic.IGenericDAO;
import br.com.lbomfim.domain.VendaProduto;

/**
 * @author Lucas Bomfim 
 */

public class VendaProdutoDAO extends GenericDAO<VendaProduto, Long> implements IGenericDAO<VendaProduto, Long> {
	
	public VendaProdutoDAO() {
		super(VendaProduto.class);
	}
}
