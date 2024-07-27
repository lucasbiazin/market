package br.com.tbiazin.service;


import br.com.tbiazin.domain.Venda;

import br.com.tbiazin.repository.IVendaRepository;
import br.com.tbiazin.service.IVendaService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VendaServices implements IVendaService {

    private IVendaRepository vendaRepository = null;

    public VendaServices(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    @Override
    public Venda updateVenda(Venda venda) {
        return vendaRepository.update(venda);
    }

    @Override
    public void deleteVenda(Long id) {
        vendaRepository.deleteById(id);
    }

  

    @Override
    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

	@Override
	public void salvar(Venda venda) {
		return;
	}

	@Override
	public Venda getVendaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
