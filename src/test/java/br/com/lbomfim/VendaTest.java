package br.com.lbomfim;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lbomfim.dao.ClienteDAO;
import br.com.lbomfim.dao.ProdutoDAO;
import br.com.lbomfim.dao.VendaDAO;
import br.com.lbomfim.domain.Cliente;
import br.com.lbomfim.domain.Produto;
import br.com.lbomfim.domain.Venda;

/**
 * @author Lucas Bomfim
 */

public class VendaTest {

    private ClienteDAO clienteDAO;
    private VendaDAO vendaDAO;
    private ProdutoDAO produtoDAO;

    @Before
    public void setUp() {
        clienteDAO = new ClienteDAO();
        vendaDAO = new VendaDAO();
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void tearDown() {
        clienteDAO = null;
        vendaDAO = null;
        produtoDAO = null;
    }

    @Test
    public void cadastrarVenda() throws Exception {
    	    	
        // CADASTRAR CLIENTE
        Cliente cliente = new Cliente();
        cliente.setNome("Pedro");
        cliente.setCpf(12309865412L);
        cliente.setTelefone(987116277L);
        cliente.setEndereco("Avenida Teste");
        cliente.setNumero(654);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        clienteDAO.cadastrar(cliente);

        // CADASTRAR PRODUTO_1
        Produto produto1 = new Produto();
        produto1.setNome("TV Samsung");
        produto1.setValor(2000d);
        produtoDAO.cadastrar(produto1);

        // CADASTRAR PRODUTO_2
        Produto produto2 = new Produto();
        produto2.setNome("Playstation 5");
        produto2.setValor(3600d);
        produtoDAO.cadastrar(produto2);

        // CADASTRAR VENDA
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.adicionarProduto(produto1, 2);
        venda.adicionarProduto(produto2, 4);
        venda.setData_venda(Instant.now());
        vendaDAO.cadastrar(venda);

        // CONSULTAR NO BANCO
        Venda consultar_venda = vendaDAO.consultar(venda.getId());
        Cliente consultar_cliente = clienteDAO.consultar(cliente.getId());
        Produto consultar_produto1 = produtoDAO.consultar(produto1.getId());
        Produto consultar_produto2 = produtoDAO.consultar(produto2.getId());

        assertNotNull(consultar_cliente);
        assertNotNull(consultar_produto1);
        assertNotNull(consultar_produto2);
        assertNotNull(consultar_venda);

        // ATUALIZAR
        consultar_cliente.setEstado("PE");
        consultar_produto1.setValor(2299.99d);
        consultar_produto2.setValor(3499.99d);
        consultar_venda = vendaDAO.consultar(venda.getId());

        // EXCLUIR VENDA (NÃO SEI COMO POSSO EXCLUIR A TABELA VENDA_PRODUTO)
        //produtoDAO.excluir(consultar_produto1);
        //produtoDAO.excluir(consultar_produto2);
        //vendaDAO.excluir(consultar_venda);
        //clienteDAO.excluir(consultar_cliente);

        // BUSCAR TUDO
        Collection<Venda> lista = vendaDAO.buscarTodos();
        assertTrue(lista.size() >= 0);
    }

}
