package it.almaviva.difesa.sipad.dsctpCatmilit.mapper;

import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.dto.TpDsctpCatmilitDTO;
import it.almaviva.difesa.sipad.aadba.dsctpcatmilit.entity.TpDsctpCatmilit;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpDsctpCatmilitMapper extends IMapper<TpDsctpCatmilitDTO, TpDsctpCatmilit> {
}
