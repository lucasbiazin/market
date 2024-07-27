package br.com.tbiazin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tbiazin.domain.ProdutoVenda;

@Repository
public interface IProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {
    }
