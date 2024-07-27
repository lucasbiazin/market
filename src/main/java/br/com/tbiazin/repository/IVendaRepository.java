package br.com.tbiazin.repository;

import br.com.tbiazin.domain.Venda;

public interface IVendaRepository extends IBaseRepository<Venda, Long> {

	Venda save(Venda venda);
    // Adicionar métodos específicos para Venda

}