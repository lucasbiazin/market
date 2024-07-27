package br.com.tbiazin.screen;

import br.com.tbiazin.Util.TipoDePagamentoEnum;
import br.com.tbiazin.domain.Cliente;
import br.com.tbiazin.domain.PDV;
import br.com.tbiazin.domain.Produto;
import br.com.tbiazin.domain.ProdutoVenda;
import br.com.tbiazin.domain.Venda;
import br.com.tbiazin.service.CupomFiscalService;
import br.com.tbiazin.service.VendaService;
import br.com.tbiazin.service.CupomFiscalServices;
import br.com.tbiazin.service.VendaServices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
                List<Venda> vendasCliente = new ArrayList<>();
        List<Venda> vendasPDV = new ArrayList<>();
        List<ProdutoVenda> vendasProduto1 = new ArrayList<>();
        List<ProdutoVenda> vendasProduto2 = new ArrayList<>();

                Cliente cliente = new Cliente(1L, "João Silva", "123456789", "Rua A", 100L, "Bairro B", vendasCliente);
        PDV pdv = new PDV(1L, "Caixa 1");

        Produto produto1 = new Produto(1L, "Produto 1", "Descrição 1", BigDecimal.valueOf(20.00), "Tipo 1", "1234567890123", LocalDate.now(), 100, vendasProduto1);
        Produto produto2 = new Produto(2L, "Produto 2", "Descrição 2", BigDecimal.valueOf(30.00), "Tipo 2", "1234567890124", LocalDate.now(), 50, vendasProduto2);

                ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, null, 2, produto1.getPreco().doubleValue());
        ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, null, 1, produto2.getPreco().doubleValue());

        List<ProdutoVenda> produtosVenda = new ArrayList<>();
        produtosVenda.add(produtoVenda1);
        produtosVenda.add(produtoVenda2);

                double valorTotal = produtosVenda.stream()
            .mapToDouble(p -> p.getProduto().getPreco().doubleValue() * p.getQuantidade())
            .sum();

        Venda venda = new Venda(
            1L,
            LocalDate.now(),
            cliente,
            pdv,
            produtosVenda,
            TipoDePagamentoEnum.DINHEIRO,
            valorTotal
        );

                produtoVenda1.setVenda(venda);
        produtoVenda2.setVenda(venda);

                vendasCliente.add(venda);
        vendasPDV.add(venda);
        vendasProduto1.add(produtoVenda1);
        vendasProduto2.add(produtoVenda2);

                VendaService vendaService = new VendaServices();
        CupomFiscalService cupomFiscalService = new CupomFiscalServices();

                String cupomFiscal = cupomFiscalService.gerarCupomFiscal(venda);
        System.out.println(cupomFiscal);
    }
}
