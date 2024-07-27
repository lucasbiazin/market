package br.com.tbiazin.repository;


import br.com.tbiazin.domain.Cliente;

public interface IClienteRepository extends IBaseRepository<Cliente, Long> {

	Cliente save(Cliente cliente);
    // TODO implementar métodos para clientes
}



