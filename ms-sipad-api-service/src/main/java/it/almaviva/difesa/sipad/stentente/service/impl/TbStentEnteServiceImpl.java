package it.almaviva.difesa.sipad.stentente.service.impl;

import it.almaviva.difesa.sipad.aadba.stentente.dto.TbStentEnteDTO;
import it.almaviva.difesa.sipad.aadba.stentente.entity.TbStentEnte;
import it.almaviva.difesa.sipad.stentente.mapper.TbStentEnteMapper;
import it.almaviva.difesa.sipad.aadba.stentente.repository.TbStentEnteRepository;
import it.almaviva.difesa.sipad.stentente.service.TbStentEnteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TbStentEnteServiceImpl implements TbStentEnteService {

    @Autowired
    TbStentEnteRepository tbStentEnteRepository;

    @Autowired
    TbStentEnteMapper tbStentEnteMapper;

    @Override
    public List<TbStentEnteDTO> getEnteByDenomEnte(String denomEnte) {
        List<TbStentEnte> tbStentEntes = tbStentEnteRepository.getTbStentEnteByStentDenomEnteContainingIgnoreCaseOrderById(denomEnte);
        return tbStentEnteMapper.toDto(tbStentEntes);

    }

    @Override
    public TbStentEnteDTO getEnteById(String idEnte) {
        Optional<TbStentEnte> tbStentEnte = tbStentEnteRepository.findById(idEnte);
        return tbStentEnteMapper.toDto(tbStentEnte.orElse(null));
    }

}
