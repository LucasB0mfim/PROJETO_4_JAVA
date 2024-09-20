package br.com.lbomfim;

import java.time.Instant;

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
        Cliente cliente = new Cliente();
        cliente.setNome("Pedro");
        cliente.setCpf(12309865412L);
        cliente.setTelefone(987116277L);
        cliente.setEndereco("Avenida Teste");
        cliente.setNumero(654);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        clienteDAO.cadastrar(cliente);

        Produto produto = new Produto();
        produto.setNome("TV Samsung");
        produto.setValor(2000d);
        produto.setQuantidade(5);
        produtoDAO.cadastrar(produto);

        
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setProduto(produto);
        venda.setQuantidade(produto.getQuantidade());
        venda.setValor_total(valor_total(produto));
        venda.setData_venda(Instant.now());
        vendaDAO.cadastrar(venda);
    }
    
    public Double valor_total(Produto produto) {
    	Integer qtd = produto.getQuantidade();
    	Double valor = produto.getValor();
    	Double soma = qtd * valor;
    	return soma;
    }
}
