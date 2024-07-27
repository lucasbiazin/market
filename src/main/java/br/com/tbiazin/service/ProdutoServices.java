package br.com.tbiazin.service;


import br.com.tbiazin.domain.Produto;
import br.com.tbiazin.repository.IProdutoRepository;
import br.com.tbiazin.service.IProdutoService;

import java.util.List;

public class ProdutoServices implements IProdutoService {

    private final IProdutoRepository produtoRepository;

    public ProdutoServices(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto updateProduto(Produto produto) {
        return produtoRepository.update(produto);
    }

    @Override
    public void deleteProduto(Long id) {
        produtoRepository.delete(id);
    }

    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
}
