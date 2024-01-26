package it.almaviva.difesa.sipad.vwan001anagrafedip.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.dto.VwAn001AnagrafeDipDTO;
import it.almaviva.difesa.sipad.aadba.vwan001anagrafedip.entity.VwAn001AnagrafeDip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VwAn001AnagrafeDipMapper extends IMapper<VwAn001AnagrafeDipDTO, VwAn001AnagrafeDip> {

}
