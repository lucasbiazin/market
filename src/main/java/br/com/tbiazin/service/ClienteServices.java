package br.com.tbiazin.service;


import br.com.tbiazin.domain.Cliente;
import br.com.tbiazin.repository.IClienteRepository;
import br.com.tbiazin.service.IClienteService;

import java.util.List;

public class ClienteServices implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteServices(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.update(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.delete(id);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}
