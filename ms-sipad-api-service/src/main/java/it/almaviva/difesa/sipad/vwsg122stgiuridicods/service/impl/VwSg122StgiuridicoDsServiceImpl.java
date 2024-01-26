package it.almaviva.difesa.sipad.vwsg122stgiuridicods.service.impl;

import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.dto.VwSg122StgiuridicoDsDTO;
import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.entity.VwSg122StgiuridicoDs;
import it.almaviva.difesa.sipad.vwsg122stgiuridicods.mapper.VwSg122StgiuridicoDsMapper;
import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.repository.VwSg122StgiuridicoDsRepository;
import it.almaviva.difesa.sipad.vwsg122stgiuridicods.service.VwSg122StgiuridicoDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwSg122StgiuridicoDsServiceImpl implements VwSg122StgiuridicoDsService {

    @Autowired
    VwSg122StgiuridicoDsRepository sg122StgiuridicoDsRepository;

    @Autowired
    VwSg122StgiuridicoDsMapper sg122StgiuridicoDsMapper;

    @Override
    public VwSg122StgiuridicoDsDTO getById(Long idDip) {
        VwSg122StgiuridicoDs result = sg122StgiuridicoDsRepository.findByIdDip(idDip);
        return sg122StgiuridicoDsMapper.toDto(result);
    }

}
