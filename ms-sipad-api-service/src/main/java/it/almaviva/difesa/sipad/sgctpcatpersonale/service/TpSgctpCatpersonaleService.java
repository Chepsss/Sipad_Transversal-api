package it.almaviva.difesa.sipad.sgctpcatpersonale.service;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.StaffCategoriesDTO;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;

public interface TpSgctpCatpersonaleService {

    StaffCategoriesDTO getStaffCategories();

    TpSgctpCatpersonaleDTO getCatMilitareById(Long id);

}
