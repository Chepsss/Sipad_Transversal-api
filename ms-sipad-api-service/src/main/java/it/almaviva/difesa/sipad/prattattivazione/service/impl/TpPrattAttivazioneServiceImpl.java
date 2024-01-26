package it.almaviva.difesa.sipad.prattattivazione.service.impl;

import it.almaviva.difesa.sipad.aadba.prattattivazione.dto.response.TpPrattAttivazioneDTO;
import it.almaviva.difesa.sipad.aadba.prattattivazione.entity.TpPrattAttivazione;
import it.almaviva.difesa.sipad.prattattivazione.mapper.TpPrattAttivazioneMapper;
import it.almaviva.difesa.sipad.aadba.prattattivazione.repository.TpPrattAttivazioneRepository;
import it.almaviva.difesa.sipad.prattattivazione.service.TpPrattAttivazioneService;
import it.almaviva.difesa.sipad.aadba.prattattivazione.specifications.TpPrattAttivazioneSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class TpPrattAttivazioneServiceImpl implements TpPrattAttivazioneService {

    @Autowired
    TpPrattAttivazioneRepository tpPrattAttivazioneRepository;
    @Autowired
    TpPrattAttivazioneMapper tpPrattAttivazioneMapper;


    @Override
    public List<TpPrattAttivazioneDTO> list(String acrProc, Boolean onlyNotExpired) {
        TpPrattAttivazioneSpecification tpPrattAttivazioneSpecification = new TpPrattAttivazioneSpecification();
        tpPrattAttivazioneSpecification.setAcrProc(acrProc);
        tpPrattAttivazioneSpecification.setOnlyNotExpired(onlyNotExpired);
        List<TpPrattAttivazione> tpPrattAttivaziones = tpPrattAttivazioneRepository.findAll(tpPrattAttivazioneSpecification);

        return tpPrattAttivazioneMapper.toDto(tpPrattAttivaziones);
    }

    @Override
    public TpPrattAttivazioneDTO getById(Long id) {
        return tpPrattAttivazioneMapper.toDto(tpPrattAttivazioneRepository.findById(id).orElse(null));
    }

}
