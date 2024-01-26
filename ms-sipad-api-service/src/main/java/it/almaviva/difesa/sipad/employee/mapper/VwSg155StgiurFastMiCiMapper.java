package it.almaviva.difesa.sipad.employee.mapper;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiurFastMiCiDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiurFastMiCiEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface VwSg155StgiurFastMiCiMapper extends IMapper<VwSg155StgiurFastMiCiDTO, VwSg155StgiurFastMiCiEntity> {
}
