
package it.almaviva.difesa.sipad.prtpotprocedimento.mapper.service.impl;

import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.dto.response.TpPrtpoTprocedimentoDTO;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import it.almaviva.difesa.sipad.prtpotprocedimento.mapper.TpPrtpoTprocedimentoMapper;
import it.almaviva.difesa.sipad.prtpotprocedimento.mapper.service.TpPrtpoTprocedimentoService;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.repository.TpPrtpoTprocedimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class TpPrtpoTprocedimentoServiceImpl implements TpPrtpoTprocedimentoService {

    @Autowired
    TpPrtpoTprocedimentoRepository prtpoTprocedimentoRepository;
    @Autowired
    TpPrtpoTprocedimentoMapper tpPrtpoTprocedimentoMapper;


    @Override
    public List<TpPrtpoTprocedimentoDTO> getType(String type, String acrProc) {
        List<TpPrtpoTprocedimento> tpPrtpoTprocedimentos = prtpoTprocedimentoRepository.getType(acrProc, type);
        return tpPrtpoTprocedimentoMapper.toDto(tpPrtpoTprocedimentos);
    }

    @Override
    public List<TpPrtpoTprocedimentoDTO> notExpiredList(String tipoAttivazione, String acrProc) {
        LocalDate currentDate = LocalDate.now();
        List<TpPrtpoTprocedimento> tpPrtpoTprocedimentos = prtpoTprocedimentoRepository.notExpiredList(acrProc, tipoAttivazione, currentDate);
        return tpPrtpoTprocedimentoMapper.toDto(tpPrtpoTprocedimentos);
    }

    @Override
    public TpPrtpoTprocedimentoDTO getTypeById(Long id) {
        return tpPrtpoTprocedimentoMapper.toDto(prtpoTprocedimentoRepository.findById(id).orElse(null));
    }

    @Override
    public List<Long> getTypesId(String type, String acrProc, String prtpoAcrProc){
        return prtpoTprocedimentoRepository.getTpPrtpoTprocedimentoListId(acrProc, type, prtpoAcrProc);
    }
}
