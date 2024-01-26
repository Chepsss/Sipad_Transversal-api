package it.almaviva.difesa.sipad.stfaaforzaarmata.service.impl;

import it.almaviva.difesa.sipad.stfaaforzaarmata.mapper.TpStfaaForzaArmataMapper;
import it.almaviva.difesa.sipad.stfaaforzaarmata.service.TpStfaaForzaArmataService;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto.TpStfaaForzaArmataDTO;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity.TpStfaaForzaArmata;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.repository.TpStfaaForzaArmataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpStfaaForzaArmataServiceImpl implements TpStfaaForzaArmataService {

    @Autowired
    TpStfaaForzaArmataRepository tpStfaaForzaArmataRepository;

    @Autowired
    TpStfaaForzaArmataMapper tpStfaaForzaArmataMapper;

    @Override
    public List<TpStfaaForzaArmataDTO> getForzeArmateCessazione() {
        List<TpStfaaForzaArmata> tpStfaaForzaArmatas = tpStfaaForzaArmataRepository.getForzeArmateCessazione();
        return tpStfaaForzaArmataMapper.toDto(tpStfaaForzaArmatas);
    }

    @Override
    public List<TpStfaaForzaArmataDTO> getForzeArmateDecretazione() {
        List<TpStfaaForzaArmata> tpStfaaForzaArmatas = tpStfaaForzaArmataRepository.getForzeArmateDecretazione();
        return tpStfaaForzaArmataMapper.toDto(tpStfaaForzaArmatas);
    }

    @Override
    public TpStfaaForzaArmataDTO getById(String id) {
        Optional<TpStfaaForzaArmata> tpStfaaForzaArmata = tpStfaaForzaArmataRepository.findById(id);
        return tpStfaaForzaArmataMapper.toDto(tpStfaaForzaArmata.orElse(null));
    }

}
