package br.com.tbiazin.service;

import br.com.tbiazin.domain.Venda;

public interface CupomFiscalService {
    String gerarCupomFiscal(Venda venda);
}
