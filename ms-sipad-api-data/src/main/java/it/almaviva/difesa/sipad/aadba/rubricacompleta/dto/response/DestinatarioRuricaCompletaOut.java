package it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DestinatarioRuricaCompletaOut implements Serializable {

    private static final long serialVersionUID = -6373502947897740134L;

    private String idDestinatario;
    private String codAooDestinatario;
    private String nomeDestinatario;
    private String viaDestinatario;
    private String cittaDestinatario;
    private String mailDestinatario;
    private String pecDestinatario;


}
