package it.almaviva.difesa.sipad.employee.mapper;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.VwSg155StgiuridicoFastDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.VwSg155StgiuridicoFastEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface VwSg155StgiuridicoFastMapper extends IMapper<VwSg155StgiuridicoFastDTO, VwSg155StgiuridicoFastEntity> {
}
