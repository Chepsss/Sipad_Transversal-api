package it.almaviva.difesa.sipad.aadba.struarubricaaoo.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DestinatarioOut implements Serializable {

    private Long idDestinatario;
    private String codAooDestinatario;
    private String nomeDestinatario;
    private String viaDestinatario;
    private String cittaDestinatario;
    private String mailDestinatario;
    private String pecDestinatario;


}
