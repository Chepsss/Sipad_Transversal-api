package it.almaviva.difesa.sipad.prattattivazione.mapper;

import it.almaviva.difesa.sipad.aadba.prattattivazione.dto.response.TpPrattAttivazioneDTO;
import it.almaviva.difesa.sipad.aadba.prattattivazione.entity.TpPrattAttivazione;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * Mapper for the entity {@link TpPrattAttivazione} and its DTO {@link TpPrattAttivazioneDTO}.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TpPrattAttivazioneMapper extends IMapper<TpPrattAttivazioneDTO, TpPrattAttivazione> {}
