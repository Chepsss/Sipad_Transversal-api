package it.almaviva.difesa.sipad.employee.service;


import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiurFastMiCiCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiurFastMiCiDTO;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public interface VwSg155StgiurFastMiCiService {
    
    OutputGenericListResponse findUsers (Pageable pageable ) throws EntityNotFoundException;
    VwSg155StgiurFastMiCiDTO findUserByFiscaleCode (String fiscaleCode ) throws EntityNotFoundException;
    Page<VwSg155StgiurFastMiCiDTO> findAllUsersByCriteria (VwSg155StgiurFastMiCiCriteria criteria, Pageable pageable) throws EntityNotFoundException;
    VwSg155StgiurFastMiCiDTO findUserById(Long employeeId) throws EntityNotFoundException;
    List<VwSg155StgiurFastMiCiDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException;
}
