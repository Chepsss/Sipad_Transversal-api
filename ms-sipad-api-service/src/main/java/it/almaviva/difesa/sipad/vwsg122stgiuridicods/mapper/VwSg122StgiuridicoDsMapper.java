package it.almaviva.difesa.sipad.vwsg122stgiuridicods.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.dto.VwSg122StgiuridicoDsDTO;
import it.almaviva.difesa.sipad.aadba.vwsg122stgiuridicods.entity.VwSg122StgiuridicoDs;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VwSg122StgiuridicoDsMapper extends IMapper<VwSg122StgiuridicoDsDTO, VwSg122StgiuridicoDs> {

}
