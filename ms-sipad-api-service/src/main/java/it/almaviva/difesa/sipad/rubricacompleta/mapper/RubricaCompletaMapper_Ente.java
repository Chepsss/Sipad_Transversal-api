package it.almaviva.difesa.sipad.rubricacompleta.mapper;

import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.RubricaCompletaDTO;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.entity.RubricaCompleta;
import it.almaviva.difesa.sipad.shared.util.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
//cr16
@Mapper( componentModel = "spring")
public interface RubricaCompletaMapper_Ente extends IMapper<RubricaCompletaDTO, RubricaCompleta> {

    //mappato ipotizzando le donominazioni identiche alla classe
    @Mapping(target = "id", source = "id")
    @Mapping(target = "denomNom", source = "denomNom")
    @Mapping(target = "indVia", source = "indVia")
    @Mapping(target = "indCitta", source = "indCitta")
    @Mapping(target = "indCap", source = "indCap")
    @Mapping(target = "indPro", source = "indPro")
    @Mapping(target = "mailNom", source = "mailNom")
    @Mapping(target = "pecNom", source = "pecNom")
    @Mapping(target = "codIpa", source = "codIpa")
    @Mapping(target = "codUnivAoo", source = "codUnivAoo")
    @Mapping(target = "codAoo", source = "codAoo")
    @Mapping(target = "tipoContatto", source = "tipoContatto")
    @Mapping(target = "titolo", source = "titolo")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cognome", source = "cognome")
    @Mapping(target = "cfPiva", source = "cfPiva")
    @Mapping(target = "denomUfficio", source = "denomUfficio")
    @Mapping(target = "denomAoo", source = "denomAoo")
    @Mapping(target = "codiceUo", source = "codiceUo")
    @Mapping(target = "denomUo", source = "denomUo")
    RubricaCompletaDTO toDto(RubricaCompleta entity);





}