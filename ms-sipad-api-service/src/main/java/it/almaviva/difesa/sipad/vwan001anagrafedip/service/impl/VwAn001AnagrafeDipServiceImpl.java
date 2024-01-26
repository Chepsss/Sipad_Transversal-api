package it.almaviva.difesa.sipad.vwan001anagrafedip.service.impl;

import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.dto.VwAn001AnagrafeDipDTO;
import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.entity.VwAn001AnagrafeDip;
import it.almaviva.difesa.sipad.vwan001anagrafedip.mapper.VwAn001AnagrafeDipMapper;
import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.repository.VwAn001AnagrafeDipRepository;
import it.almaviva.difesa.sipad.vwan001anagrafedip.service.VwAn001AnagrafeDipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwAn001AnagrafeDipServiceImpl implements VwAn001AnagrafeDipService {

    @Autowired
    VwAn001AnagrafeDipRepository an001AnagrafeDipRepository;

    @Autowired
    VwAn001AnagrafeDipMapper an001AnagrafeDipMapper;

    @Override
    public VwAn001AnagrafeDipDTO getById(Long idDip) {
        VwAn001AnagrafeDip result = an001AnagrafeDipRepository.findByIdDip(idDip);
        return an001AnagrafeDipMapper.toDto(result);
    }

}
