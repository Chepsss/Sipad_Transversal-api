package it.almaviva.difesa.sipad.vwsg001stgiuridicomil.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.dto.VwSg001StgiuridicoMilDTO;
import it.almaviva.difesa.sipad.aadba.vwsg001stgiuridicomil.entity.VwSg001StgiuridicoMil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VwSg001StgiuridicoMilMapper extends IMapper<VwSg001StgiuridicoMilDTO, VwSg001StgiuridicoMil> {

}
