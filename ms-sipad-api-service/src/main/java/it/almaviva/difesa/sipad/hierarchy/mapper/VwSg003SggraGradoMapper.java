package it.almaviva.difesa.sipad.hierarchy.mapper;



import it.almaviva.difesa.sipad.aadba.hierarchy.dto.VwSg003SggraGradoDTO;
import it.almaviva.difesa.sipad.aadba.hierarchy.entity.VwSg003SggraGradoEntity;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel="spring")
public interface VwSg003SggraGradoMapper extends IMapper<VwSg003SggraGradoDTO, VwSg003SggraGradoEntity> {
}
