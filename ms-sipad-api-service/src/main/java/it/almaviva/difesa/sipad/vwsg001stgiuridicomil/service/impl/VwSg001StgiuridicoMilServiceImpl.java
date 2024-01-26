package it.almaviva.difesa.sipad.vwsg001stgiuridicomil.service.impl;

import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.dto.VwSg001StgiuridicoMilDTO;
import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.entity.VwSg001StgiuridicoMil;
import it.almaviva.difesa.sipad.vwsg001stgiuridicomil.mapper.VwSg001StgiuridicoMilMapper;
import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.repository.VwSg001StgiuridicoMilRepository;
import it.almaviva.difesa.sipad.vwsg001stgiuridicomil.service.VwSg001StgiuridicoMilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwSg001StgiuridicoMilServiceImpl implements VwSg001StgiuridicoMilService {

    @Autowired
    VwSg001StgiuridicoMilRepository sg001StgiuridicoMilRepository;

    @Autowired
    VwSg001StgiuridicoMilMapper sg001StgiuridicoMilMapper;

    @Override
    public VwSg001StgiuridicoMilDTO getById(Long idDip) {
        VwSg001StgiuridicoMil result = sg001StgiuridicoMilRepository.findByIdDip(idDip);
        return sg001StgiuridicoMilMapper.toDto(result);
    }

}
