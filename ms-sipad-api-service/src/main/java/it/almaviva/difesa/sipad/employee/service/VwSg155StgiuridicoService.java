package it.almaviva.difesa.sipad.employee.service;


import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoCriteria;
import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoFastCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoDTO;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoFastDTO;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public interface VwSg155StgiuridicoService {
    
    OutputGenericListResponse findUsers (Pageable pageable ) throws EntityNotFoundException;
    VwSg155StgiuridicoDTO findUserByFiscaleCode (String fiscaleCode ) throws EntityNotFoundException;
    Page<VwSg155StgiuridicoDTO> findAllUsersByCriteria (VwSg155StgiuridicoCriteria criteria, Pageable pageable) throws EntityNotFoundException;
    VwSg155StgiuridicoDTO findUserById(Long employeeId) throws EntityNotFoundException;
    Short findHierarchicalValueByGradeDescription (String gradeDescription) throws EntityNotFoundException;
    List<VwSg155StgiuridicoDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException;
    Page<VwSg155StgiuridicoFastDTO> getUsersPartialInfo (VwSg155StgiuridicoFastCriteria criteria, Pageable pageable) throws EntityNotFoundException;
    List<VwSg155StgiuridicoFastDTO> findUsersFastById(List<Long> usersIds) throws EntityNotFoundException;
    Boolean checkNotCompatibleWithCessation(Long employeeId) throws EntityNotFoundException;
    List<Long> getUsersIdByCriteria (VwSg155StgiuridicoCriteria criteria) throws EntityNotFoundException;
}
