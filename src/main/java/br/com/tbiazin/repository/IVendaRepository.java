package br.com.tbiazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tbiazin.domain.Venda;

public interface IVendaRepository extends JpaRepository<Venda, Long> {

	Venda save(Venda venda);

	Venda update(Venda venda);
}