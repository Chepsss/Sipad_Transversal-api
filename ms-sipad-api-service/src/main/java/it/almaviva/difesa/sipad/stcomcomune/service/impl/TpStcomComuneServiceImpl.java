package it.almaviva.difesa.sipad.stcomcomune.service.impl;

import it.almaviva.difesa.sipad.aadba.stcomcomune.dto.TpStcomComuneDTO;
import it.almaviva.difesa.sipad.aadba.stcomcomune.entity.TpStcomComune;
import it.almaviva.difesa.sipad.stcomcomune.mapper.TpStcomComuneMapper;
import it.almaviva.difesa.sipad.aadba.stcomcomune.repository.TpStcomComuneRepository;
import it.almaviva.difesa.sipad.stcomcomune.service.TpStcomComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpStcomComuneServiceImpl implements TpStcomComuneService {

    @Autowired
    TpStcomComuneRepository tpStcomComuneRepository;

    @Autowired
    TpStcomComuneMapper tpStcomComuneMapper;

    @Override
    public List<TpStcomComuneDTO> listCities() {
        List<TpStcomComune> tpStcomComunes = tpStcomComuneRepository.findAllByOrderByStcomDescrComuneAsc();
        return tpStcomComuneMapper.toDto(tpStcomComunes);
    }

    @Override
    public TpStcomComuneDTO getCityById(Long idCity) {
        Optional<TpStcomComune> tpStcomComune = tpStcomComuneRepository.findById(idCity);
        return tpStcomComuneMapper.toDto(tpStcomComune.orElse(null));
    }

    @Override
    public List<TpStcomComuneDTO> listCitiesByProvince(Long idProvince) {
        List<TpStcomComune> tpStcomComunes = tpStcomComuneRepository.findAllByStcomStpro_IdOrderByStcomDescrComuneAsc(idProvince);
        return tpStcomComuneMapper.toDto(tpStcomComunes);
    }

}
