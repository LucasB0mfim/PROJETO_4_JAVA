package br.com.lbomfim.dao;

import br.com.lbomfim.dao.generic.GenericDAO;
import br.com.lbomfim.dao.generic.IGenericDAO;
import br.com.lbomfim.domain.Venda;

/**
 * @author Lucas Bomfim 
 */

public class VendaDAO extends GenericDAO<Venda> implements IGenericDAO<Venda> {

	public VendaDAO() {
		super(Venda.class);
	}
}
