package it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.service.impl;

import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.criteria.VwSg123StgiuridicoDsCriteria;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto.VwSg123StgiuridicoDsunificDTO;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.entity.VwSg123StgiuridicoDsunific;
import it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.mapper.VwSg123StgiuridicoDsunificMapper;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.repository.VwSg123StgiuridicoDsunificRepository;
import it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.service.VwSg123StgiuridicoDsunificService;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.specification.VwSg123StgiuridicoDsSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VwSg123StgiuridicoDsunificServiceImpl implements VwSg123StgiuridicoDsunificService {

    @Autowired
    VwSg123StgiuridicoDsunificRepository sg123StgiuridicoDsunificRepository;

    @Autowired
    VwSg123StgiuridicoDsunificMapper sg123StgiuridicoDsunificMapper;

    @Autowired
    VwSg123StgiuridicoDsSpecification sg123StgiuridicoDsSpecification;

    @Override
    public VwSg123StgiuridicoDsunificDTO getById(Long employeeId) {
        VwSg123StgiuridicoDsunific result = sg123StgiuridicoDsunificRepository.findBySg123IdDip(employeeId)
                .orElseThrow( () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage()) );
        return sg123StgiuridicoDsunificMapper.toDto(result);
    }

    /***
     * Method to find all users based on criterias
     * @param criteria for search users
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public Page<VwSg123StgiuridicoDsunificDTO> findAllUsersByCriteria(VwSg123StgiuridicoDsCriteria criteria, Pageable pageable) throws EntityNotFoundException {
        Specification<VwSg123StgiuridicoDsunific> filterSpecification = sg123StgiuridicoDsSpecification.getSpecification(criteria);
        Page<VwSg123StgiuridicoDsunific> pagedResults = sg123StgiuridicoDsunificRepository.findAll(filterSpecification, pageable);
        return pagedResults.map(sg123StgiuridicoDsunificMapper::toDto);
    }

    /***
     * Method to find one user by fiscal-code
     * @param fiscaleCode specifc parameter
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public VwSg123StgiuridicoDsunificDTO findUserByFiscaleCode(String fiscaleCode) throws EntityNotFoundException {
        if( fiscaleCode == null ){
            log.error("Fiscal code is null");
            throw new EntityNotFoundException ( StatusEnum.MISSING_FISCAL_CODE.getNameMessage());
        }
        VwSg123StgiuridicoDsunific stgiuridico = sg123StgiuridicoDsunificRepository.findBySg123CodiceFiscaleEqualsIgnoreCase( fiscaleCode )
                .orElseThrow( () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage()) );

        return sg123StgiuridicoDsunificMapper.toDto(stgiuridico);
    }

    @Override
    public List<VwSg123StgiuridicoDsunificDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException {
        var listEmployees = sg123StgiuridicoDsunificRepository.findByIds(usersIds);
        Set<Long> idSet = new HashSet<>();
        List<VwSg123StgiuridicoDsunific> employeesDistinctByEmployeeId = listEmployees.stream()
                .filter(e -> idSet.add(e.getSg123IdDip()))
                .collect(Collectors.toList());
        return sg123StgiuridicoDsunificMapper.toDto(employeesDistinctByEmployeeId);
    }

    /***
     * Method to find all users ID based on criterias
     * @param criteria for search users
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public List<Long> getUsersIdByCriteria(VwSg123StgiuridicoDsCriteria criteria) throws EntityNotFoundException {
        return sg123StgiuridicoDsSpecification.lastNameFistNameAndCodeFiscalSpecification(criteria);
    }
}
