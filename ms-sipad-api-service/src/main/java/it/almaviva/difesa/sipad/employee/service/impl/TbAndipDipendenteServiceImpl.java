package it.almaviva.difesa.sipad.employee.service.impl;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.TbAndipDipendenteDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.TbAndipDipendenteEntity;
import it.almaviva.difesa.sipad.employee.mapper.TbAndipDipendenteMapper;
import it.almaviva.difesa.sipad.aadba.employee.repository.TbAndipDipendenteEntityRepository;
import it.almaviva.difesa.sipad.employee.service.TbAndipDipendenteService;
import it.almaviva.difesa.sipad.shared.util.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
@Slf4j
public class TbAndipDipendenteServiceImpl  implements TbAndipDipendenteService {

    @Autowired
    private TbAndipDipendenteEntityRepository tbAndipDipendenteEntityRepository;
    @Autowired
    private TbAndipDipendenteMapper tbAndipDipendenteMapper;

    @Override
    public TbAndipDipendenteDTO findUserByFiscaleCode(String fiscaleCode) throws EntityNotFoundException {
        if( fiscaleCode == null ){
            log.error("Fiscal code is null");
            throw new EntityNotFoundException ( StatusEnum.MISSING_FISCAL_CODE.getNameMessage());
        }

        TbAndipDipendenteEntity dipendente = tbAndipDipendenteEntityRepository.findByAndipCodFsc( fiscaleCode )
                .orElseThrow( () -> new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage()) );

        return tbAndipDipendenteMapper.toDto(dipendente);
    }

    @Override
    public TbAndipDipendenteDTO findUserByEmployerId(Long employerId){
        TbAndipDipendenteEntity dipendente = tbAndipDipendenteEntityRepository.findByandipIdPk(employerId);
        if(null == dipendente){
            throw new EntityNotFoundException(StatusEnum.USER_NOT_FOUND.getNameMessage());
        }
        return tbAndipDipendenteMapper.toDto(dipendente);
    }
}
