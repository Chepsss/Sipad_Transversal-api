package it.almaviva.difesa.sipad.proceeding.mapper;

import it.almaviva.difesa.sipad.aadba.proceeding.dto.response.VwDo007ProcedimentiDTO;
import it.almaviva.difesa.sipad.aadba.proceeding.entity.VwDo007ProcedimentiEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface VwDo007ProcedimentiMapper extends IMapper<VwDo007ProcedimentiDTO, VwDo007ProcedimentiEntity> {

}
