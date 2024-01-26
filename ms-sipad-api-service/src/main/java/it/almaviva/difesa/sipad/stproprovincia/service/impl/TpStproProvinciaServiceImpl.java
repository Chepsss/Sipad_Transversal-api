package it.almaviva.difesa.sipad.stproprovincia.service.impl;

import it.almaviva.difesa.sipad.aadba.stproprovincia.dto.TpStproProvinciaDTO;
import it.almaviva.difesa.sipad.aadba.stproprovincia.entity.TpStproProvincia;
import it.almaviva.difesa.sipad.stproprovincia.mapper.TpStproProvinciaMapper;
import it.almaviva.difesa.sipad.aadba.stproprovincia.repository.TpStproProvinciaRepository;
import it.almaviva.difesa.sipad.stproprovincia.service.TpStproProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpStproProvinciaServiceImpl implements TpStproProvinciaService {

    @Autowired
    TpStproProvinciaRepository tpStproProvinciaRepository;

    @Autowired
    TpStproProvinciaMapper tpStproProvinciaMapper;

    @Override
    public List<TpStproProvinciaDTO> listProvinces() {
        List<TpStproProvincia> tpStproProvincias = tpStproProvinciaRepository.findAllByOrderByStproCDescrProvinciaAsc();
        return tpStproProvinciaMapper.toDto(tpStproProvincias);
    }

    @Override
    public TpStproProvinciaDTO getProvinceById(Long idProvince) {
        Optional<TpStproProvincia> tpStproProvincia = tpStproProvinciaRepository.findById(idProvince);
        return tpStproProvinciaMapper.toDto(tpStproProvincia.orElse(null));
    }

}
