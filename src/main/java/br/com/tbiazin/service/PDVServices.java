package br.com.tbiazin.service;


import br.com.tbiazin.domain.PDV;
import br.com.tbiazin.repository.IPDVRepository;
import br.com.tbiazin.service.IPDVService;

import java.util.List;

public class PDVServices implements IPDVService {

    private final IPDVRepository pdvRepository;

    public PDVServices(IPDVRepository pdvRepository) {
        this.pdvRepository = pdvRepository;
    }

    @Override
    public PDV createPDV(PDV pdv) {
        return pdvRepository.save(pdv);
    }

    @Override
    public PDV updatePDV(PDV pdv) {
        return pdvRepository.update(pdv);
    }

    @Override
    public void deletePDV(Long id) {
        pdvRepository.delete(id);
    }

    @Override
    public PDV getPDVById(Long id) {
        return pdvRepository.findById(id);
    }

    @Override
    public List<PDV> getAllPDVs() {
        return pdvRepository.findAll();
    }
}
