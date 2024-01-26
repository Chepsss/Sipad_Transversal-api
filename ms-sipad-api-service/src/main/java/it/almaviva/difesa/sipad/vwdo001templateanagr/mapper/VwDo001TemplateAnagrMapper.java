package it.almaviva.difesa.sipad.vwdo001templateanagr.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.dto.VwDo001TemplateAnagrDTO;
import it.almaviva.difesa.sipad.aadba.vwdo001templateanagr.entity.VwDo001TemplateAnagr;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VwDo001TemplateAnagrMapper extends IMapper<VwDo001TemplateAnagrDTO, VwDo001TemplateAnagr> {

}
