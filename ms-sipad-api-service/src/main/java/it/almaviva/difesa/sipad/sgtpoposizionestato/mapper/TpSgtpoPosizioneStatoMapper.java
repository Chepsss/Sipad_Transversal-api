package it.almaviva.difesa.sipad.sgtpoposizionestato.mapper;

import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto.TpSgtpoPosizioneStatoDTO;
import it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.entity.TpSgtpoPosizioneStato;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpSgtpoPosizioneStatoMapper extends IMapper<TpSgtpoPosizioneStatoDTO, TpSgtpoPosizioneStato> {
}
