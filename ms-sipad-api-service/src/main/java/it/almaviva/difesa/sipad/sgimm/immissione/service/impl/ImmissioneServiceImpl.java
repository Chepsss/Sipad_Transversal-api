package it.almaviva.difesa.sipad.sgimm.immissione.service.impl;

import it.almaviva.difesa.sipad.aadba.immissione.dto.response.ImmissioneDto;
import it.almaviva.difesa.sipad.aadba.immissione.entity.Immissione;
import it.almaviva.difesa.sipad.sgimm.immissione.mapper.ImmissioneMapper;
import it.almaviva.difesa.sipad.aadba.immissione.repository.ImmissioneRepository;
import it.almaviva.difesa.sipad.sgimm.immissione.service.ImmissioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.ServiceNotFoundException;

@Service
public class ImmissioneServiceImpl implements ImmissioneService {

    @Autowired
    ImmissioneMapper immissioneMapper;

    @Autowired
    ImmissioneRepository immissioneRepository;

    @Override
    @Transactional
    public ImmissioneDto findById(Long id) throws ServiceNotFoundException {
        Immissione vi = immissioneRepository.findFirstByIdAndSgstaCodOrderByDataImmDesc(id, "VI");
        if(null == vi){
            throw new ServiceNotFoundException("record non trovato");
        }
        return immissioneMapper.toDto(vi);
    }

}
