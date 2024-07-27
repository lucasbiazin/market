package br.com.tbiazin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.com.tbiazin.Util.TipoDePagamentoEnum;
import br.com.tbiazin.domain.Cliente;
import br.com.tbiazin.domain.PDV;
import br.com.tbiazin.domain.Produto;
import br.com.tbiazin.domain.ProdutoVenda;
import br.com.tbiazin.domain.Venda;
import jakarta.persistence.EntityManager;
import br.com.tbiazin.market.MarketApplicationTests;

@SpringBootTest(classes = MarketApplicationTests.class)
@Transactional
public class ProdutoVendaRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
            }

    @AfterEach
    public void tearDown() {}

    @Test
    public void testSaveProdutoVenda() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(BigDecimal.valueOf(50.00));
        produto.setDescricao("Descrição Teste");
        produto.setTipo("Tipo Teste");
        produto.setEan("1234567890123");
        produto.setDataCadastro(LocalDate.now());
        produto.setEstoque(100);

        entityManager.persist(produto);

        Cliente cliente = new Cliente();
        cliente.setNome("Nome do Cliente");
        cliente.setTelefone("123456789");
        cliente.setNumero(10L);
        cliente.setRua("rua teste");
        cliente.setBairro("Bairro do Cliente");

        entityManager.persist(cliente);

        PDV pdv = new PDV();
        pdv.setNome("caixa 1");

        entityManager.persist(pdv);

        Venda venda = new Venda();
        venda.setDataVenda(LocalDate.now());
        venda.setCliente(cliente);
        venda.setPdv(pdv);
        venda.setTipoPagamento(TipoDePagamentoEnum.DINHEIRO);
        venda.setValorTotal(0.00);

        entityManager.persist(venda);

        ProdutoVenda produtoVenda = new ProdutoVenda();
        produtoVenda.setProduto(produto);
        produtoVenda.setVenda(venda);
        produtoVenda.setQuantidade(2);
        produtoVenda.setPrecoUnitario(produto.getPreco().doubleValue());
        entityManager.persist(produtoVenda);

        assertNotNull(produtoVenda.getId());
    }
}
