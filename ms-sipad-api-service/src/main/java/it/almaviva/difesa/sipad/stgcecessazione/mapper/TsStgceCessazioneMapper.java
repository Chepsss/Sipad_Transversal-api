package it.almaviva.difesa.sipad.stgcecessazione.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.dto.TsStgceCessazioneDTO;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.TsStgceCessazione;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TsStgceCessazioneMapper extends IMapper<TsStgceCessazioneDTO, TsStgceCessazione> {

    @Mapping(target = "id.stgceCodiceFiscale", source = "stgceCodiceFiscale")
    @Mapping(target = "id.stgceNumeroDecreto", source = "stgceNumeroDecreto")
    TsStgceCessazione toEntity(TsStgceCessazioneDTO dto);

    @Mapping(target = "stgceCodiceFiscale", source = "id.stgceCodiceFiscale")
    @Mapping(target = "stgceNumeroDecreto", source = "id.stgceNumeroDecreto")
    TsStgceCessazioneDTO toDto(TsStgceCessazione entity);

}
