package it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.service;

import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.criteria.VwSg123StgiuridicoDsCriteria;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto.VwSg123StgiuridicoDsunificDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface VwSg123StgiuridicoDsunificService {

    VwSg123StgiuridicoDsunificDTO getById(Long employeeId);

    Page<VwSg123StgiuridicoDsunificDTO> findAllUsersByCriteria (VwSg123StgiuridicoDsCriteria criteria, Pageable pageable) throws EntityNotFoundException;

    VwSg123StgiuridicoDsunificDTO findUserByFiscaleCode (String fiscaleCode ) throws EntityNotFoundException;

    List<VwSg123StgiuridicoDsunificDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException;

    List<Long> getUsersIdByCriteria (VwSg123StgiuridicoDsCriteria criteria) throws EntityNotFoundException;

}
