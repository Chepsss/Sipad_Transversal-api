package it.almaviva.difesa.sipad.vwsg123stgiuridicodsunific.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.dto.VwSg123StgiuridicoDsunificDTO;
import it.almaviva.difesa.sipad.aadba.vwsg123stgiuridicodsunific.entity.VwSg123StgiuridicoDsunific;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VwSg123StgiuridicoDsunificMapper extends IMapper<VwSg123StgiuridicoDsunificDTO, VwSg123StgiuridicoDsunific> {

}
