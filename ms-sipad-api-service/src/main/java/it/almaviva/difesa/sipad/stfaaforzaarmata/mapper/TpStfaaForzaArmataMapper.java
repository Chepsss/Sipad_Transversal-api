package it.almaviva.difesa.sipad.stfaaforzaarmata.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto.TpStfaaForzaArmataDTO;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity.TpStfaaForzaArmata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TpStfaaForzaArmataMapper extends IMapper<TpStfaaForzaArmataDTO, TpStfaaForzaArmata> {
}
