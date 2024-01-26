package it.almaviva.difesa.sipad.sgimm.immissione.mapper;

import it.almaviva.difesa.sipad.aadba.immissione.dto.response.ImmissioneDto;
import it.almaviva.difesa.sipad.aadba.immissione.entity.Immissione;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImmissioneMapper extends IMapper<ImmissioneDto, Immissione>{
}
