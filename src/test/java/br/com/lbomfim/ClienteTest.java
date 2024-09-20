package br.com.lbomfim;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lbomfim.dao.ClienteDAO;
import br.com.lbomfim.domain.Cliente;

public class ClienteTest {

    private ClienteDAO clienteDAO;

    @Before
    public void setUp() {
        clienteDAO = new ClienteDAO();
    }

    @After
    public void tearDown() {
        clienteDAO = null;
    }

    @Test
    public void testCadastrarCliente() throws Exception {
        
        Cliente cliente = new Cliente();
        
        cliente.setNome("Carlos Silva");
        cliente.setCpf(12345678901L);
        cliente.setTelefone(987654321L);
        cliente.setEndereco("Avenida Exemplo");
        cliente.setNumero(456);
        cliente.setCidade("Rio de Janeiro");
        cliente.setEstado("RJ");

        
        Cliente clienteCadastrado = clienteDAO.cadastrar(cliente);
        assertNotNull("O cliente cadastrado deve ter um ID", clienteCadastrado.getId());
    }
}
