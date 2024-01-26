package it.almaviva.difesa.sipad.rubricacompleta.service;


import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.RubricaCompletaDTO;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRubricaCompletaListReturnValue;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DestinatarioRuricaCompletaOut;
import it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response.DettaglioRubricaCompletaOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubricaCompletaService {

    DestinatarioRubricaCompletaListReturnValue elenco(String filtro, Integer max);

    Page<DestinatarioRuricaCompletaOut> elencoPaginate(String filtro, Pageable pageable);


    DettaglioRubricaCompletaOut getByKey(String key);

    List<RubricaCompletaDTO> getRubricaCompletaDenomEnteCC(String denomEnteCC);

    RubricaCompletaDTO getEnteByIdEnte(String idEnte);
}
