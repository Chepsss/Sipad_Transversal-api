package it.almaviva.difesa.sipad.employee.mapper;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface VwSg155StgiuridicoMapper extends IMapper<VwSg155StgiuridicoDTO, VwSg155StgiuridicoEntity> {
}
