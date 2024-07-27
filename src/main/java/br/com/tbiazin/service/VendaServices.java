package br.com.tbiazin.service;


import br.com.tbiazin.domain.Venda;
import br.com.tbiazin.repository.IVendaRepository;
import br.com.tbiazin.service.VendaService;

import java.util.List;

public class VendaServices implements VendaService {

    private IVendaRepository vendaRepository = null;

    public VendaServices() {
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
        vendaRepository.delete(id);
    }

    @Override
    public Venda getVendaById(Long id) {
        return vendaRepository.findById(id);
    }

    @Override
    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }
}
