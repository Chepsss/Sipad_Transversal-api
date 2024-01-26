package it.almaviva.difesa.sipad.hierarchy.service.impl;


import it.almaviva.difesa.sipad.aadba.hierarchy.entity.VwSg003SggraGradoEntity;
import it.almaviva.difesa.sipad.aadba.hierarchy.repository.VwSg003SggraGradoEntityRepository;
import it.almaviva.difesa.sipad.hierarchy.service.VwSg003SggraGradoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Transactional(readOnly = true)
@Slf4j
public class VwSg003SggraGradoServiceImpl implements VwSg003SggraGradoService {


    @Autowired
    private VwSg003SggraGradoEntityRepository vwSg003SggraGradoEntityRepository;


    @Override
    public Short findHierarchicalValueByGradeDescription(String gradeDescription) throws EntityNotFoundException {
        if( gradeDescription == null ){
            log.error("Grade description is null");
            throw new EntityNotFoundException ( "Grade description Required" );
        }
        List<VwSg003SggraGradoEntity> stgiuridicoList = vwSg003SggraGradoEntityRepository.findBySg003DescrGradoIgnoreCase(gradeDescription);
        if (!CollectionUtils.isEmpty(stgiuridicoList)) {
            return stgiuridicoList.get(0).getSg003SggraValGerarchia();
        }
        log.error("Not grade found");
        throw new EntityNotFoundException ( "Any grade found" );
    }
}
