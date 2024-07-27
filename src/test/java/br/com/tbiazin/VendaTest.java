package br.com.tbiazin;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.tbiazin.Util.TipoDePagamentoEnum;
import br.com.tbiazin.dao.ClienteDao;
import br.com.tbiazin.dao.PDVDao;
import br.com.tbiazin.dao.ProdutoVendaDao;
import br.com.tbiazin.dao.VendaDao;
import br.com.tbiazin.domain.Cliente;
import br.com.tbiazin.domain.PDV;
import br.com.tbiazin.domain.ProdutoVenda;
import br.com.tbiazin.domain.Venda;

public class VendaTest {

    private VendaDao vendaDao = new VendaDao();
    private ClienteDao clienteDao = new ClienteDao();
    private PDVDao pdvDao = new PDVDao();
    private ProdutoVendaDao produtoVendaDao = new ProdutoVendaDao();

    @Test
    public void cadastrarVenda() {
        Cliente cliente = new Cliente();
        cliente.setNome("Lucas Biazin");
        cliente.setTelefone("17981716648");
        cliente.setRua("Rua dos Bambis");
        cliente.setNumero(10L);
        cliente.setBairro("Bairro Trikas");
        Cliente clienteCadastrado = clienteDao.cadastrar(cliente);
        assertNotNull(clienteCadastrado);
        assertNotNull(clienteCadastrado.getId());

        PDV pdv = new PDV();
        pdv.setNome("PDV Principal");

        // Verifica se já existe um PDV com o mesmo nome
        PDV pdvExistente = pdvDao.buscarPorNome(pdv.getNome());
        if (pdvExistente != null) {
            pdv = pdvExistente;
        } else {
            pdv = pdvDao.cadastrar(pdv);
        }

        assertNotNull(pdv);
        assertNotNull(pdv.getId());

        ProdutoVenda produtoVenda = new ProdutoVenda();
        ProdutoVenda produtoVendaCadastrado = produtoVendaDao.cadastrar(produtoVenda);
        assertNotNull(produtoVendaCadastrado);
        assertNotNull(produtoVendaCadastrado.getId());

        Venda venda = new Venda();
        venda.setDataVenda(LocalDate.now());
        venda.setCliente(clienteCadastrado);
        venda.setPdv(pdv);
        venda.setProdutos(new ArrayList<ProdutoVenda>() {{ add(produtoVendaCadastrado); }});
        venda.setTipoPagamento(TipoDePagamentoEnum.CARTÃO_CREDITO);
        venda.setValorTotal(100.0);

        Venda vendaPersistida = vendaDao.cadastrar(venda);

        Venda vendaCadastrada = vendaDao.buscarPorId(vendaPersistida.getId());
        assertNotNull(vendaCadastrada);
        assertNotNull(vendaCadastrada.getCliente());
        assertNotNull(vendaCadastrada.getPdv());
        assertNotNull(vendaCadastrada.getProdutos());
        assertNotNull(vendaCadastrada.getTipoPagamento());
    }
}
