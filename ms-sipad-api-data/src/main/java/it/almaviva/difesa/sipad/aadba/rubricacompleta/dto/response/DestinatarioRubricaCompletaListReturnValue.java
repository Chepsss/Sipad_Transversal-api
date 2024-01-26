package it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DestinatarioRubricaCompletaListReturnValue implements Serializable {

    private static final long serialVersionUID = 2836160238686129343L;
    private transient List<DestinatarioRuricaCompletaOut> destinatariEsterni;
}
