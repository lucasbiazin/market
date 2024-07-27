package br.com.tbiazin;




import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import br.com.tbiazin.dao.ClienteDao;
import br.com.tbiazin.dao.IClienteDao;
import br.com.tbiazin.domain.Cliente;

public class ClienteTest {

    private IClienteDao clienteDao;

    public ClienteTest() {
        clienteDao = new ClienteDao();
    }

    @Test
    public void cadastrar() {
        Cliente cliente = new Cliente();
        cliente.setId(1l);
        cliente.setNome("Lucas Biazin");
        cliente.setTelefone("17981716648");
        cliente.setRua("Rua");
        cliente.setNumero(10l);
        cliente.setBairro("Bairro");

        clienteDao.cadastrar(cliente);

        Cliente clienteCadastrado = clienteDao.buscarPorId(20);
        assertNotNull(clienteCadastrado);
        assertTrue(clienteCadastrado.getNome().equals("Lucas Biazin"));
    }
}
