package it.almaviva.difesa.sipad.docattdocumento.mapper;

import it.almaviva.difesa.sipad.aadba.docatcdocumento.dto.response.TpDocatCdocumentoDTO;
import it.almaviva.difesa.sipad.aadba.docatcdocumento.entity.TpDocatCDocumento;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface TpDocatCDocumentoMapper extends IMapper<TpDocatCdocumentoDTO, TpDocatCDocumento> {
}
