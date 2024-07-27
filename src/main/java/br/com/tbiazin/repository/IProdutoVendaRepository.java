package br.com.tbiazin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tbiazin.domain.ProdutoVenda;

@Repository
public interface IProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {

	ProdutoVenda update(ProdutoVenda produtoVenda);

	void delete(Long id);
	
	Optional<ProdutoVenda> findById(Long id);
}
