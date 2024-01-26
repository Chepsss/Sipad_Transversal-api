package it.almaviva.difesa.sipad.titolario.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.titolario.dto.response.TitolarioDto;
import it.almaviva.difesa.sipad.aadba.titolario.entity.TpDotitTitolario;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface TitolarioMapper extends IMapper<TitolarioDto, TpDotitTitolario> {

}
