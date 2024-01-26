package it.almaviva.difesa.sipad.sgctpcatpersonale.service.impl;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.StaffCategoriesDTO;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity.TpSgctpCatpersonale;
import it.almaviva.difesa.sipad.sgctpcatpersonale.mapper.TpSgctpCatpersonaleMapper;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.repository.TpSgctpCatpersonaleRepository;
import it.almaviva.difesa.sipad.sgctpcatpersonale.service.TpSgctpCatpersonaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TpSgctpCatpersonaleServiceImpl implements TpSgctpCatpersonaleService {

    @Autowired
    TpSgctpCatpersonaleRepository tpSgctpCatpersonaleRepository;

    @Autowired
    TpSgctpCatpersonaleMapper tpSgctpCatpersonaleMapper;

    @Override
    public StaffCategoriesDTO getStaffCategories() {
        StaffCategoriesDTO staffCategories = new StaffCategoriesDTO();
        staffCategories.setCategorieMilitari(tpSgctpCatpersonaleRepository.getStaffCategories());
        return staffCategories;
    }

    @Override
    public TpSgctpCatpersonaleDTO getCatMilitareById(Long id) {
        TpSgctpCatpersonale catMilitare = tpSgctpCatpersonaleRepository.getById(id);
        return tpSgctpCatpersonaleMapper.toDto(catMilitare);
    }

}
