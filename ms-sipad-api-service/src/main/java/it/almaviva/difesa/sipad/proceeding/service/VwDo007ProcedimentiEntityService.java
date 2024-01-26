package it.almaviva.difesa.sipad.proceeding.service;

import it.almaviva.difesa.sipad.aadba.proceeding.criteria.VwDo007ProcedimentiCriteria;
import it.almaviva.difesa.sipad.aadba.proceeding.dto.response.VwDo007ProcedimentiDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;


public interface VwDo007ProcedimentiEntityService {

    Page<VwDo007ProcedimentiDTO> findAllProceedingsByCriteria (VwDo007ProcedimentiCriteria criteria, Pageable pageable) throws EntityNotFoundException;
}
