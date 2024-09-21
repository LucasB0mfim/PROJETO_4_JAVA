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

        Produto produto_1 = new Produto();
        produto_1.setNome("TV Samsung");
        produto_1.setValor(2000d);
        produtoDAO.cadastrar(produto_1);

        Produto produto_2 = new Produto();
        produto_2.setNome("Playstation 5");
        produto_2.setValor(3600d);
        produtoDAO.cadastrar(produto_2);

        Venda venda = new Venda();
        venda.setCliente(cliente);

        venda.adicionarProduto(produto_1, 2);
        venda.adicionarProduto(produto_2, 1);

        venda.setData_venda(Instant.now());
        vendaDAO.cadastrar(venda);
    }
}
