package it.almaviva.difesa.sipad.registrosegnatura.service.impl;

import it.almaviva.difesa.sipad.aadba.registrosegnatura.dto.response.TpRegistroSegnaturaDTO;
import it.almaviva.difesa.sipad.aadba.registrosegnatura.entity.TpRegistroSegnatura;
import it.almaviva.difesa.sipad.aadba.registrosegnatura.repository.TpRegistroSegnaturaRepository;
import it.almaviva.difesa.sipad.registrosegnatura.mapper.TpRegistroSegnaturaMapper;
import it.almaviva.difesa.sipad.registrosegnatura.service.RegistriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RegistriServiceImpl implements RegistriService {

    @Autowired
    TpRegistroSegnaturaRepository registroSegnaturaRepository;


    @Autowired
    TpRegistroSegnaturaMapper registroSegnaturaMapper;

    @Override
    public List<TpRegistroSegnaturaDTO> list() {

        List<TpRegistroSegnatura> all = registroSegnaturaRepository.findAll();
        all.sort(Comparator.comparing(TpRegistroSegnatura::getTipoRegistro));
        return registroSegnaturaMapper.toDto(all);
    }

    @Override
    public TpRegistroSegnaturaDTO findByTipoRegistro(String tipoRegistro){
        return registroSegnaturaMapper.toDto(registroSegnaturaRepository.findByTipoRegistro(tipoRegistro));
    }
}
