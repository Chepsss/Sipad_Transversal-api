package it.almaviva.difesa.sipad.employee.service.impl;

import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoCriteria;
import it.almaviva.difesa.sipad.aadba.employee.criteria.VwSg155StgiuridicoFastCriteria;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoDTO;
import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoFastDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoEntity;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoFastEntity;
import it.almaviva.difesa.sipad.employee.mapper.VwSg155StgiuridicoFastMapper;
import it.almaviva.difesa.sipad.employee.mapper.VwSg155StgiuridicoMapper;
import it.almaviva.difesa.sipad.aadba.employee.repository.VwSg155StgiuridicoEntityFastRepository;
import it.almaviva.difesa.sipad.aadba.employee.repository.VwSg155StgiuridicoEntityRepository;
import it.almaviva.difesa.sipad.employee.service.VwSg155StgiuridicoService;
import it.almaviva.difesa.sipad.aadba.employee.specification.VwSg155StgiuridicoFastSpecification;
import it.almaviva.difesa.sipad.aadba.employee.specification.VwSg155StgiuridicoSpecification;
import it.almaviva.difesa.sipad.shared.dto.response.OutputGenericListResponse;
import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@Slf4j
public class VwSg155StgiuridicoServiceImpl implements VwSg155StgiuridicoService {
    
    @Autowired
    private VwSg155StgiuridicoEntityRepository vwSg155StgiuridicoEntityRepository;
    @Autowired
    private VwSg155StgiuridicoEntityFastRepository vwSg155StgiuridicoEntityFastRepository;
    @Autowired
    private VwSg155StgiuridicoMapper vwSg155StgiuridicoMapper;
    @Autowired
    private VwSg155StgiuridicoFastMapper vwSg155StgiuridicoFastMapper;
    @Autowired
    private VwSg155StgiuridicoSpecification vwSg155StgiuridicoSpecification;

    @Autowired
    private VwSg155StgiuridicoFastSpecification vwSg155StgiuridicoFastSpecification;

    private final String SPE = "SERVIZIO PERMANENTE EFFETTIVO";
    private final String SPAD = "SERVIZIO PERMANENTE A DISPOSIZIONE";


    /***
     * Method to find a list of users with pagination
     * @param pageable parameters for pagination
     * @return list of users
     * @throws EntityNotFoundException
     */
    @Override
    public OutputGenericListResponse findUsers(Pageable pageable) throws EntityNotFoundException {
    
        Page<VwSg155StgiuridicoEntity> stgiuridico = vwSg155StgiuridicoEntityRepository.findAll( pageable );
        return new OutputGenericListResponse( null, stgiuridico ) ;
    }


    /***
     * Method to find one user by fiscal-code
     * @param fiscaleCode specifc parameter
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public VwSg155StgiuridicoDTO findUserByFiscaleCode (String fiscaleCode ) throws EntityNotFoundException {
    
        if( fiscaleCode == null ){
            log.error("Fiscal code is null");
            throw new EntityNotFoundException ( StatusEnum.MISSING_FISCAL_CODE.getNameMessage());
        }
        
        VwSg155StgiuridicoEntity stgiuridico = vwSg155StgiuridicoEntityRepository.findBySg155CodiceFiscaleEqualsIgnoreCase( fiscaleCode )
                                                .orElseThrow( () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage()) );
        
        return vwSg155StgiuridicoMapper.toDto(stgiuridico);
    }

    /***
     * Method to find all users based on criterias
     * @param criteria for search users
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public Page<VwSg155StgiuridicoDTO> findAllUsersByCriteria(VwSg155StgiuridicoCriteria criteria, Pageable pageable) throws EntityNotFoundException {
        Specification<VwSg155StgiuridicoEntity> filterSpecification = vwSg155StgiuridicoSpecification.getSpecification(criteria);
        Page<VwSg155StgiuridicoEntity> pagedResults = vwSg155StgiuridicoEntityRepository.findAll(filterSpecification, pageable);
        return pagedResults.map(vwSg155StgiuridicoMapper::toDto);
    }

    /***
     * Method to find specific user by employee id
     * @param employeeId
     * @return
     * @throws EntityNotFoundException
     */
    @Override
    public VwSg155StgiuridicoDTO findUserById(Long employeeId) throws EntityNotFoundException {
        if( employeeId == null ){
            log.error("Employee id is null");
            throw new EntityNotFoundException (StatusEnum.MISSING_EMPLOYEE_ID.getNameMessage());
        }
        VwSg155StgiuridicoEntity stgiuridico = vwSg155StgiuridicoEntityRepository.findBySg155IdDip(employeeId).orElseThrow(
                () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage())
        );
        return vwSg155StgiuridicoMapper.toDto(stgiuridico);
    }

    /***
     * Method to get hierarchical value by grade description
     * @param gradeDescription
     * @return
     * @throws EntityNotFoundException
     */
    @Override
    public Short findHierarchicalValueByGradeDescription(String gradeDescription) throws EntityNotFoundException {
        if( gradeDescription == null ){
            log.error("Grade description is null");
            throw new EntityNotFoundException ( "Grade description Required" );
        }
        List<VwSg155StgiuridicoEntity> stgiuridicoList = vwSg155StgiuridicoEntityRepository.findBySg155DescrGradoIgnoreCase(gradeDescription);
        if (!CollectionUtils.isEmpty(stgiuridicoList)) {
            return stgiuridicoList.get(0).getSg155ValGerarchia();
        }
        log.error("Not grade found");
        throw new EntityNotFoundException ( StatusEnum.GRADE_NOT_FOUND.getNameMessage() );
    }


    /***
     * Method to find group of users by list of employee ids
     * @param usersIds
     * @return
     * @throws EntityNotFoundException
     */
    @Override
    public List<VwSg155StgiuridicoDTO> findUsersById(List<Long> usersIds) throws EntityNotFoundException {
        var listEmployees = vwSg155StgiuridicoEntityRepository.findByIds(usersIds);
        Set<Long> idSet = new HashSet<>();
        List<VwSg155StgiuridicoEntity> employeesDistinctByEmployeeId = listEmployees.stream()
                .filter(e -> idSet.add(e.getSg155IdDip()))
                .collect(Collectors.toList());
        return vwSg155StgiuridicoMapper.toDto(employeesDistinctByEmployeeId);
    }

    /***
     * Method to get partial info about of users group, based on specific criteria
     * @param criteria
     * @param pageable
     * @return
     * @throws EntityNotFoundException
     */
    @Override
    public Page<VwSg155StgiuridicoFastDTO> getUsersPartialInfo(VwSg155StgiuridicoFastCriteria criteria, Pageable pageable) throws EntityNotFoundException {
        Specification<VwSg155StgiuridicoFastEntity> filterSpecification = vwSg155StgiuridicoFastSpecification.getSpecification(criteria);
        Page<VwSg155StgiuridicoFastEntity> pagedResults = vwSg155StgiuridicoEntityFastRepository.findAll(filterSpecification, pageable);
        return pagedResults.map(vwSg155StgiuridicoFastMapper::toDto);
    }

    /***
     * Method to find partial info of users group based on list of employee ids
     * @param usersIds
     * @return
     * @throws EntityNotFoundException
     */
    @Override
    public List<VwSg155StgiuridicoFastDTO> findUsersFastById(List<Long> usersIds) throws EntityNotFoundException {
        var listEmployees = vwSg155StgiuridicoEntityFastRepository.findByIds(usersIds);
        Set<Long> idSet = new HashSet<>();
        List<VwSg155StgiuridicoFastEntity> employeesDistinctByEmployeeId = listEmployees.stream()
                .filter(e -> idSet.add(e.getSg155IdDip()))
                .collect(Collectors.toList());
        return vwSg155StgiuridicoFastMapper.toDto(employeesDistinctByEmployeeId);
    }

    @Override
    public Boolean checkNotCompatibleWithCessation(Long employeeId) throws EntityNotFoundException {
        return vwSg155StgiuridicoEntityRepository.isNotCompatibleWithCessation(employeeId);
    }

    /***
     * Method to find all users based on criterias
     * @param criteria for search users
     * @return dto
     * @throws EntityNotFoundException
     */
    @Override
    public List<Long> getUsersIdByCriteria(VwSg155StgiuridicoCriteria criteria) throws EntityNotFoundException {
        return vwSg155StgiuridicoSpecification.lastNameFistNameAndCodeFiscalSpecification(criteria);
    }
}
