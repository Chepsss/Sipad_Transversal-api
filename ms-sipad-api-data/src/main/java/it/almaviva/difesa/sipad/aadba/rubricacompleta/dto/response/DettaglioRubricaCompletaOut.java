package it.almaviva.difesa.sipad.aadba.rubricacompleta.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DettaglioRubricaCompletaOut implements Serializable {

    private String codAooDestinatario;
    private String idDestinatario;
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

    private String tipoContatto;
// campi per tipoContatto = PF
    private String titolo;
    private String nome;
    private String cognome;
    private String cf;
// campi per tipoContatto = IPA
    private String denominazioneAoo;
    private String codiceIpa;
    private String codiceUnivocoAoo;
    private String codiceAoo;
// campi per tipoContatto = PG
    private String partitaIva;
// campi per PAE
    private String denominazioneUfficio;
}
