package br.com.tbiazin.service;

import br.com.tbiazin.domain.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
    void deleteCliente(Long id);
    Cliente getClienteById(Long id);
    List<Cliente> getAllClientes();
}
