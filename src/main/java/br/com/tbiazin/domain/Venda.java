package br.com.tbiazin.domain;

import jakarta.persistence.*;

import br.com.tbiazin.Util.TipoDePagamentoEnum;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_VENDA")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "sq_venda", allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pdv_id", nullable = false)
    private PDV pdv;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoVenda> produtos;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento", nullable = false)
    private TipoDePagamentoEnum tipoPagamento;

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    public Venda() {}

    public Venda(Long id, LocalDate dataVenda, Cliente cliente, PDV pdv, List<ProdutoVenda> produtos, TipoDePagamentoEnum tipoPagamento, double valorTotal) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.pdv = pdv;
        this.produtos = produtos;
        this.tipoPagamento = tipoPagamento;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PDV getPdv() {
        return pdv;
    }

    public void setPdv(PDV pdv) {
        this.pdv = pdv;
    }

    public List<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }

    public TipoDePagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoDePagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
