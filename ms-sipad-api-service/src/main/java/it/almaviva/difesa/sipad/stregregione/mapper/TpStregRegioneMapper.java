package it.almaviva.difesa.sipad.stregregione.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stregregione.dto.TpStregRegioneDTO;
import it.almaviva.difesa.sipad.aadba.stregregione.entity.TpStregRegione;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpStregRegioneMapper extends IMapper<TpStregRegioneDTO, TpStregRegione> {
}
