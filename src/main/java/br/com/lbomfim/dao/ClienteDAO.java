package br.com.lbomfim.dao;

import br.com.lbomfim.dao.generic.GenericDAO;
import br.com.lbomfim.dao.generic.IGenericDAO;
import br.com.lbomfim.domain.Cliente;

/**
 * @author Lucas Bomfim 
 */

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IGenericDAO<Cliente, Long> {

	public ClienteDAO() {
		super(Cliente.class);
	}
}

