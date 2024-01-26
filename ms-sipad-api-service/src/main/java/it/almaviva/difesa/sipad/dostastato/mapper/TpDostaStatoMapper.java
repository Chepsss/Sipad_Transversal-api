package it.almaviva.difesa.sipad.dostastato.mapper;

import it.almaviva.difesa.sipad.aadba.dosta.dto.TpDostaStatoDTO;
import it.almaviva.difesa.sipad.aadba.dosta.entity.TpDostaStato;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpDostaStatoMapper extends IMapper<TpDostaStatoDTO, TpDostaStato> {
}
