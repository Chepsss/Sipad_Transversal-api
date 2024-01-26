package it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DettaglioDestinatarioOut implements Serializable {

    private String codAooDestinatario;
    private Long idDestinatario;
    private String nomeDestinatario;
    private String viaDestinatario;
    private String cittaDestinatario;
    private String capDestinatario;
    private String provinciaDestinatario;
    private String statoDestinatario;
    private String telefonoDestinatario;
    private String faxDestinatario;
    private String mailDestinatario;
    private String pecDestinatario;


}
