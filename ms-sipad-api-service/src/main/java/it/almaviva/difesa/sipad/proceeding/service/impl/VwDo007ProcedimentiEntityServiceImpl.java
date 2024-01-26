package it.almaviva.difesa.sipad.proceeding.service.impl;

import it.almaviva.difesa.sipad.aadba.proceeding.criteria.VwDo007ProcedimentiCriteria;
import it.almaviva.difesa.sipad.aadba.proceeding.dto.response.VwDo007ProcedimentiDTO;
import it.almaviva.difesa.sipad.aadba.proceeding.entity.VwDo007ProcedimentiEntity;
import it.almaviva.difesa.sipad.proceeding.mapper.VwDo007ProcedimentiMapper;
import it.almaviva.difesa.sipad.aadba.proceeding.repository.VwDo007ProcedimentiEntityRepository;
import it.almaviva.difesa.sipad.proceeding.service.VwDo007ProcedimentiEntityService;
import it.almaviva.difesa.sipad.aadba.proceeding.specification.VwDo007ProcedimentiSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@Transactional(readOnly = true)
@Slf4j
public class VwDo007ProcedimentiEntityServiceImpl implements VwDo007ProcedimentiEntityService {


    @Autowired
    private VwDo007ProcedimentiEntityRepository vwDo007ProcedimentiEntityRepository;
    @Autowired
    private VwDo007ProcedimentiMapper vwDo007ProcedimentiMapper;
    @Autowired
    private VwDo007ProcedimentiSpecification vwDo007ProcedimentiSpecification;


    /***
     * Method to find all user's proceedings based on criterias
     * @param criteria for search proceedings of user
     * @param pageable parameters for pagination
     * @return list of all proceedings
     * @throws EntityNotFoundException
     */
    @Override
    public Page<VwDo007ProcedimentiDTO> findAllProceedingsByCriteria(VwDo007ProcedimentiCriteria criteria, Pageable pageable) throws EntityNotFoundException {
        Specification<VwDo007ProcedimentiEntity> filterSpecification = vwDo007ProcedimentiSpecification.getSpecification(criteria);
        Page<VwDo007ProcedimentiEntity> pagedResults = vwDo007ProcedimentiEntityRepository.findAll(filterSpecification, pageable);
        return pagedResults.map(vwDo007ProcedimentiMapper::toDto);
    }


}
