package it.almaviva.difesa.sipad.aadba.dotiptdocumento.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class TpDotipTDocumentoDto implements Serializable{

    private static final long serialVersionUID = 5797466398966267915L;


    private String cod;

    private String descrTip;

    private String acrTip;

    private String prtpaId;

    private Date dataIniz;

    private Date dataFine;

    private String flagTipo;

    private String flagFirma;

    private String flagArchivio;

    private String flagInvio;

    private long docatId;

    private String flagEsp;

    private String flagCan;

    private String flagMod;

    private Timestamp dataIns;

    private String codUltAgg;

    private Timestamp dataUltAgg;


}
