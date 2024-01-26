package it.almaviva.difesa.sipad.prtpotprocedimento.mapper.service;

import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.dto.response.TpPrtpoTprocedimentoDTO;

import java.util.List;

public interface TpPrtpoTprocedimentoService {

    List<TpPrtpoTprocedimentoDTO> getType(String type, String acrProc);

    List<TpPrtpoTprocedimentoDTO> notExpiredList(String type, String acrProc);

    TpPrtpoTprocedimentoDTO getTypeById(Long id);

    List<Long> getTypesId(String type, String acrProc, String prtpoAcrProc);
}
