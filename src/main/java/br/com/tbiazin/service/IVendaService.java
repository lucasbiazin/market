package br.com.tbiazin.service;

import br.com.tbiazin.domain.Venda;

import java.util.List;

public interface IVendaService {
    Venda createVenda(Venda venda);
    Venda updateVenda(Venda venda);
    void deleteVenda(Long id);
    Venda getVendaById(Long id);
    List<Venda> getAllVendas();
	void salvar(Venda venda);
}
