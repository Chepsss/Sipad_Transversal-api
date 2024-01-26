package it.almaviva.difesa.sipad.rubricacompleta.mapper;


import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRuricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DettaglioRubricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.entity.RubricaCompleta;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RubricaCompletaMapper extends IMapper<DestinatarioRuricaCompletaOut, RubricaCompleta> {
    @Named("copyPropertiesDestinatarioRurica")
    @Mapping(target = "idDestinatario", source = "key")
    @Mapping(target = "codAooDestinatario", source = "codAoo")
    @Mapping(target = "nomeDestinatario", source = "denomNom")
    @Mapping(target = "viaDestinatario", source = "indVia")
    @Mapping(target = "cittaDestinatario", source = "indCitta")
    @Mapping(target = "mailDestinatario", source = "mailNom")
    @Mapping(target = "pecDestinatario", source = "pecNom")
    DestinatarioRuricaCompletaOut copyPropertiesDestinatarioRurica(RubricaCompleta source);

    @Named("copyPropertiesDettaglioRubrica")
    @Mapping(target = "idDestinatario", source = "key")
    @Mapping(target = "codAooDestinatario", source = "codAoo")
    @Mapping(target = "nomeDestinatario", source = "denomNom")
    @Mapping(target = "viaDestinatario", source = "indVia")
    @Mapping(target = "cittaDestinatario", source = "indCitta")
    @Mapping(target = "mailDestinatario", source = "mailNom")
    @Mapping(target = "pecDestinatario", source = "pecNom")
    @Mapping(target = "tipoContatto", source = "tipoContatto")
    DettaglioRubricaCompletaOut copyPropertiesDettaglioRubrica(RubricaCompleta source);
}
