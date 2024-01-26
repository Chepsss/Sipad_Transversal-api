package it.almaviva.difesa.sipad.prtpotprocedimento.mapper;

import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.dto.response.TpPrtpoTprocedimentoDTO;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link TpPrtpoTprocedimento} and its DTO {@link TpPrtpoTprocedimentoDTO}.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TpPrtpoTprocedimentoMapper extends IMapper<TpPrtpoTprocedimentoDTO, TpPrtpoTprocedimento> {}
