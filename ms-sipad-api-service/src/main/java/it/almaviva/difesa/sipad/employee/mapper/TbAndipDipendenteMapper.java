package it.almaviva.difesa.sipad.employee.mapper;

import it.almaviva.difesa.sipad.aadba.employee.dto.response.TbAndipDipendenteDTO;
import it.almaviva.difesa.sipad.aadba.employee.entity.TbAndipDipendenteEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring")
public interface TbAndipDipendenteMapper  extends IMapper<TbAndipDipendenteDTO, TbAndipDipendenteEntity> {
}
