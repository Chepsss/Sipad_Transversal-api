package it.almaviva.difesa.sipad.stproprovincia.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stproprovincia.dto.TpStproProvinciaDTO;
import it.almaviva.difesa.sipad.aadba.stproprovincia.entity.TpStproProvincia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpStproProvinciaMapper extends IMapper<TpStproProvinciaDTO, TpStproProvincia> {
}
