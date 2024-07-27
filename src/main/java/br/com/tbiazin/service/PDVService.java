package br.com.tbiazin.service;

import br.com.tbiazin.domain.PDV;

import java.util.List;

public interface PDVService {
    PDV createPDV(PDV pdv);
    PDV updatePDV(PDV pdv);
    void deletePDV(Long id);
    PDV getPDVById(Long id);
    List<PDV> getAllPDVs();
}
