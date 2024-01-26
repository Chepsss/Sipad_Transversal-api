package it.almaviva.difesa.sipad.desk.mapper;

import it.almaviva.difesa.sipad.aadba.desk.dto.response.TbAdhocScrivaniaDto;
import it.almaviva.difesa.sipad.aadba.desk.entity.TbAdhocScrivania;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel="spring")
public interface TbAdhocScrivaniaMapper extends IMapper<TbAdhocScrivaniaDto, TbAdhocScrivania> {
}
