package br.com.tbiazin.repository;

import br.com.tbiazin.domain.PDV;

public interface IPDVRepository extends IBaseRepository<PDV, Long> {

	PDV save(PDV pdv);
    // Adicionar métodos específicos para PDV
}
