package it.almaviva.difesa.sipad.stregregione.service.impl;

import it.almaviva.difesa.sipad.aadba.stregregione.dto.TpStregRegioneDTO;
import it.almaviva.difesa.sipad.aadba.stregregione.entity.TpStregRegione;
import it.almaviva.difesa.sipad.stregregione.mapper.TpStregRegioneMapper;
import it.almaviva.difesa.sipad.aadba.stregregione.repository.TpStregRegioneRepository;
import it.almaviva.difesa.sipad.stregregione.service.TpStregRegioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpStregRegioneServiceImpl implements TpStregRegioneService {

    @Autowired
    TpStregRegioneRepository tpStregRegioneRepository;

    @Autowired
    TpStregRegioneMapper tpStregRegioneMapper;

    @Override
    public List<TpStregRegioneDTO> listRegions() {
        List<TpStregRegione> tpStregRegiones = tpStregRegioneRepository.findAllByOrderByStregDescrRegioneAsc();
        return tpStregRegioneMapper.toDto(tpStregRegiones);
    }

    @Override
    public TpStregRegioneDTO getRegionById(Long idRegion) {
        Optional<TpStregRegione> tpStregRegione = tpStregRegioneRepository.findById(idRegion);
        return tpStregRegioneMapper.toDto(tpStregRegione.orElse(null));
    }

}
