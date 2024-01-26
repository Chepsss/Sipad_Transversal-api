package it.almaviva.difesa.sipad.stnaznazione.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stnaznazione.dto.TpStnazNazioneDTO;
import it.almaviva.difesa.sipad.aadba.stnaznazione.entity.TpStnazNazione;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpStnazNazioneMapper extends IMapper<TpStnazNazioneDTO, TpStnazNazione> {
}
