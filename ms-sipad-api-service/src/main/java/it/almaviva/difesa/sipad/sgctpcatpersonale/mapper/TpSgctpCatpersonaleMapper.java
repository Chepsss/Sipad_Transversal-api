package it.almaviva.difesa.sipad.sgctpcatpersonale.mapper;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity.TpSgctpCatpersonale;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpSgctpCatpersonaleMapper extends IMapper<TpSgctpCatpersonaleDTO, TpSgctpCatpersonale> {
}
