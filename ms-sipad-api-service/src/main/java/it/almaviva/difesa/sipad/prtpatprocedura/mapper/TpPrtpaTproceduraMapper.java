package it.almaviva.difesa.sipad.prtpatprocedura.mapper;

import it.almaviva.difesa.sipad.aadba.prtpatprocedura.dto.response.TpPrtpaTproceduraDTO;
import it.almaviva.difesa.sipad.aadba.prtpatprocedura.entity.TpPrtpaTprocedura;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link TpPrtpaTprocedura} and its DTO {@link TpPrtpaTproceduraDTO}.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TpPrtpaTproceduraMapper extends IMapper<TpPrtpaTproceduraDTO, TpPrtpaTprocedura> {}
