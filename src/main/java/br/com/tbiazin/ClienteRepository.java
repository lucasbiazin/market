package br.com.tbiazin;

import br.com.tbiazin.domain.Cliente;
import br.com.tbiazin.domain.Produto;
import br.com.tbiazin.repository.IClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements IClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente save(Cliente entity) {
        clientes.add(entity);
        return entity;
    }

    @Override
    public Cliente update(Cliente entity) {
        Optional<Cliente> existingCliente = clientes.stream().filter(c -> c.getId().equals(entity.getId())).findFirst();
        if (existingCliente.isPresent()) {
            clientes.remove(existingCliente.get());
            clientes.add(entity);
            return entity;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public Cliente findById(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

	@Override
	public Cliente save(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}
}
