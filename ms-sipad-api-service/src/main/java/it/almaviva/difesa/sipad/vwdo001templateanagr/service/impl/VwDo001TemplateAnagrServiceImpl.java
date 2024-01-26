package it.almaviva.difesa.sipad.vwdo001templateanagr.service.impl;

import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.dto.VwDo001TemplateAnagrDTO;
import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.entity.VwDo001TemplateAnagr;
import it.almaviva.difesa.sipad.vwdo001templateanagr.mapper.VwDo001TemplateAnagrMapper;
import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.repository.VwDo001TemplateAnagrRepository;
import it.almaviva.difesa.sipad.vwdo001templateanagr.service.VwDo001TemplateAnagrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VwDo001TemplateAnagrServiceImpl implements VwDo001TemplateAnagrService {

    @Autowired
    VwDo001TemplateAnagrRepository do001TemplateAnagrRepository;

    @Autowired
    VwDo001TemplateAnagrMapper do001TemplateAnagrMapper;

    @Override
    public VwDo001TemplateAnagrDTO getById(Long idDip) {
        VwDo001TemplateAnagr result = do001TemplateAnagrRepository.findByIdDip(idDip);
        return do001TemplateAnagrMapper.toDto(result);
    }

}
