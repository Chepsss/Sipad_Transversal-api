package it.almaviva.difesa.sipad.registrosegnatura.mapper;

import it.almaviva.difesa.sipad.aadba.registrosegnatura.dto.response.TpRegistroSegnaturaDTO;
import it.almaviva.difesa.sipad.aadba.registrosegnatura.entity.TpRegistroSegnatura;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TpRegistroSegnaturaMapper extends IMapper<TpRegistroSegnaturaDTO, TpRegistroSegnatura> {
}
