package it.almaviva.difesa.sipad.storaorganigrammaaoo.mapper;

import it.almaviva.difesa.sipad.shared.util.IMapper;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.dto.response.TbStoraOrganigrammaAooDto;
import it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity.TbStoraOrganigrammaAoo;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface TbStoraOrganigrammaAooMapper extends IMapper<TbStoraOrganigrammaAooDto, TbStoraOrganigrammaAoo> {

}
