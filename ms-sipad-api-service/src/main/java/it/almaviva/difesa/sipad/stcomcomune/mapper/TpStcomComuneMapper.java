package it.almaviva.difesa.sipad.stcomcomune.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stcomcomune.dto.TpStcomComuneDTO;
import it.almaviva.difesa.sipad.aadba.stcomcomune.entity.TpStcomComune;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpStcomComuneMapper extends IMapper<TpStcomComuneDTO, TpStcomComune> {
}
