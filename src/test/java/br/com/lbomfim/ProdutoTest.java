package br.com.lbomfim;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lbomfim.dao.ProdutoDAO;
import br.com.lbomfim.domain.Produto;

/**
 * @author Lucas Bomfim 
 */

public class ProdutoTest {

	private ProdutoDAO produtoDAO;
	
	@Before
	public void setUp() {
		produtoDAO = new ProdutoDAO();
	}
	
	@After
	public void tearDown() {
		produtoDAO = null;
	}
	
	@Test
	public void cadastrarProdutoTest() throws Exception {
		Produto produto = new Produto();
		
		produto.setNome("Xbox Series X");
		produto.setValor(3906d);
		produto.setQuantidade(2);
		
		Produto prod_cadastrado = produtoDAO.cadastrar(produto);
		assertNotNull(prod_cadastrado);
	}
}
