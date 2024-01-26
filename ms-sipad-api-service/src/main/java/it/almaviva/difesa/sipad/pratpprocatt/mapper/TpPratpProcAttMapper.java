package it.almaviva.difesa.sipad.pratpprocatt.mapper;

import it.almaviva.difesa.sipad.aadba.pratpprocatt.dto.response.TpPratpProcAttDTO;
import it.almaviva.difesa.sipad.aadba.pratpprocatt.entity.TpPratpProcAtt;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link TpPratpProcAtt} and its DTO {@link TpPratpProcAttDTO}.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TpPratpProcAttMapper extends IMapper<TpPratpProcAttDTO, TpPratpProcAtt> {}
