package br.com.tbiazin.service;

import org.springframework.stereotype.Service;

import br.com.tbiazin.domain.Venda;

@Service
public interface ICupomFiscalService {
    String gerarCupomFiscal(Venda venda);
}
