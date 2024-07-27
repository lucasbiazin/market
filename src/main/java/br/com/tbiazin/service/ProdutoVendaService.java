package br.com.tbiazin.service;

import br.com.tbiazin.domain.ProdutoVenda;

import java.util.List;

public interface ProdutoVendaService {
    ProdutoVenda createProdutoVenda(ProdutoVenda produtoVenda);
    ProdutoVenda updateProdutoVenda(ProdutoVenda produtoVenda);
    void deleteProdutoVenda(Long id);
    ProdutoVenda getProdutoVendaById(Long id);
    List<ProdutoVenda> getAllProdutoVendas();
}
