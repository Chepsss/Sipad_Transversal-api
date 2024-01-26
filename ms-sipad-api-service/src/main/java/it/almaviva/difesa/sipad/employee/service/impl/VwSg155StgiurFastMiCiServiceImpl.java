package it.almaviva.difesa.sipad.employee.service.impl;

import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiurFastMiCiCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiurFastMiCiDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiurFastMiCiEntity;
import it.almaviva.difesa.sipad.employee.mapper.VwSg155StgiurFastMiCiMapper;
import it.almaviva.difesa.sipad.aadba.employee.repository.VwSg155StgiurFastMiCiEntityRepository;
import it.almaviva.difesa.sipad.employee.service.VwSg155StgiurFastMiCiService;
import it.almaviva.difesa.sipad.aadba.employee.specification.VwSg155StgiuridicoFastMiCiSpecification;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class VwSg155StgiurFastMiCiServiceImpl implements VwSg155StgiurFastMiCiService {

    private final VwSg155StgiurFastMiCiEntityRepository vwSg155StgiurFastMiCiEntityRepository;
    private final VwSg155StgiurFastMiCiMapper vwSg155StgiurFastMiCiMapper;
    private final VwSg155StgiuridicoFastMiCiSpecification vwSg155StgiuridicoFastMiCiSpecification;

    /***
     * Method to find a list of users with pagination
     * @param pageable parameters for pagination
     * @return list of users
     * @throws EntityNotFoundException -
     */
    @Override
    public OutputGenericListResponse findUsers(Pageable pageable) throws EntityNotFoundException {
        Page<VwSg155StgiurFastMiCiEntity> stgiuridico = vwSg155StgiurFastMiCiEntityRepository.findAll( pageable );
        return new OutputGenericListResponse( null, stgiuridico ) ;
    }

    /***
     * Method to find one user by fiscal-code
     * @param fiscaleCode specifc parameter
     * @return dto
     * @throws EntityNotFoundException -
     */
    @Override
    public VwSg155StgiurFastMiCiDTO findUserByFiscaleCode(String fiscaleCode) throws EntityNotFoundException {
        if( fiscaleCode == null ){
            log.error("Fiscal code is null");
            throw new EntityNotFoundException ( StatusEnum.MISSING_FISCAL_CODE.getNameMessage());
        }

        VwSg155StgiurFastMiCiEntity stgiuridico = vwSg155StgiurFastMiCiEntityRepository.findBySg155CodiceFiscaleEqualsIgnoreCase( fiscaleCode )
                .orElseThrow( () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage()) );

        return vwSg155StgiurFastMiCiMapper.toDto(stgiuridico);
    }

    /***
     * Method to find all users based on criterias
     * @param criteria for search users
     * @return dto
     * @throws EntityNotFoundException -
     */
    @Override
    public Page<VwSg155StgiurFastMiCiDTO> findAllUsersByCriteria(VwSg155StgiurFastMiCiCriteria criteria, Pageable pageable) throws EntityNotFoundException {
        Specification<VwSg155StgiurFastMiCiEntity> filterSpecification = vwSg155StgiuridicoFastMiCiSpecification.getSpecification(criteria);
        Page<VwSg155StgiurFastMiCiEntity> pagedResults = vwSg155StgiurFastMiCiEntityRepository.findAll(filterSpecification, pageable);
        return pagedResults.map(vwSg155StgiurFastMiCiMapper::toDto);
    }

    /***
     * Method to find specific user by employee id
     * @param employeeId - employee id
     * @return dto
     * @throws EntityNotFoundException -
     */
    @Override
    public VwSg155StgiurFastMiCiDTO findUserById(Long employeeId) throws EntityNotFoundException {
        if( employeeId == null ){
            log.error("Employee id is null");
            throw new EntityNotFoundException (StatusEnum.MISSING_EMPLOYEE_ID.getNameMessage());
        }
        VwSg155StgiurFastMiCiEntity stgiuridico = vwSg155StgiurFastMiCiEntityRepository.findBySg155IdDip(employeeId).orElseThrow(
                () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage())
        );
        return vwSg155StgiurFastMiCiMapper.toDto(stgiuridico);
    }

    @Override
    public List<VwSg155StgiurFastMiCiDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException {
        var listEmployees = vwSg155StgiurFastMiCiEntityRepository.findByIds(usersIds);
        Set<Long> idSet = new HashSet<>();
        List<VwSg155StgiurFastMiCiEntity> employeesDistinctByEmployeeId = listEmployees.stream()
                .filter(e -> idSet.add(e.getSg155IdDip()))
                .collect(Collectors.toList());
        return vwSg155StgiurFastMiCiMapper.toDto(employeesDistinctByEmployeeId);
    }
}
