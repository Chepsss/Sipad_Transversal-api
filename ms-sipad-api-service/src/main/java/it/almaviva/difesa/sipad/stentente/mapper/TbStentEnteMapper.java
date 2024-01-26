package it.almaviva.difesa.sipad.stentente.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stentente.dto.TbStentEnteDTO;
import it.almaviva.difesa.sipad.aadba.stentente.entity.TbStentEnte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TbStentEnteMapper extends IMapper<TbStentEnteDTO, TbStentEnte> {
}
