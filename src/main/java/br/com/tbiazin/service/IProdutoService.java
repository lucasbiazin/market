package br.com.tbiazin.service;

import br.com.tbiazin.domain.Produto;

import java.util.List;

public interface IProdutoService {
    Produto createProduto(Produto produto);
    Produto updateProduto(Produto produto);
    void deleteProduto(Long id);
    Produto getProdutoById(Long id);
    List<Produto> getAllProdutos();
}
