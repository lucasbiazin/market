package br.com.tbiazin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO_VENDA")
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_venda_seq")
    @SequenceGenerator(name = "produto_venda_seq", sequenceName = "sq_produto_venda", allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private double precoUnitario;

    public ProdutoVenda() {}

    public ProdutoVenda(Produto produto, Venda venda, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }


    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
