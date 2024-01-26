package it.almaviva.difesa.sipad.stnaznazione.service.impl;

import it.almaviva.difesa.sipad.aadba.stnaznazione.dto.TpStnazNazioneDTO;
import it.almaviva.difesa.sipad.aadba.stnaznazione.entity.TpStnazNazione;
import it.almaviva.difesa.sipad.stnaznazione.mapper.TpStnazNazioneMapper;
import it.almaviva.difesa.sipad.aadba.stnaznazione.repository.TpStnazNazioneRepository;
import it.almaviva.difesa.sipad.stnaznazione.service.TpStnazNazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpStnazNazioneServiceImpl implements TpStnazNazioneService {

    @Autowired
    TpStnazNazioneRepository tpStnazNazioneRepository;

    @Autowired
    TpStnazNazioneMapper tpStnazNazioneMapper;

    @Override
    public List<TpStnazNazioneDTO> listNations() {
        List<TpStnazNazione> tpStnazNaziones = tpStnazNazioneRepository.findAllByOrderByStnazDescrNazioneAsc();
        return tpStnazNazioneMapper.toDto(tpStnazNaziones);
    }

    @Override
    public TpStnazNazioneDTO getNationById(Long idNation) {
        Optional<TpStnazNazione> tpStnazNazione = tpStnazNazioneRepository.findById(idNation);
        return tpStnazNazioneMapper.toDto(tpStnazNazione.orElse(null));
    }

}
