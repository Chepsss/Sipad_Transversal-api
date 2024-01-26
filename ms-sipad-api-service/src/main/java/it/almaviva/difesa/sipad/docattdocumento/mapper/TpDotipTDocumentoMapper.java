package it.almaviva.difesa.sipad.docattdocumento.mapper;

import it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response.TpDotipTDocumentoDto;
import it.almaviva.difesa.sipad.aadba.dotiptdocumento.entity.TpDotipTDocumento;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface TpDotipTDocumentoMapper extends IMapper<TpDotipTDocumentoDto, TpDotipTDocumento> {

}
