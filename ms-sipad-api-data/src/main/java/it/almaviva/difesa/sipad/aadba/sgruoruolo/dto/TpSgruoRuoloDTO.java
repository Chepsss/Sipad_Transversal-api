package it.almaviva.difesa.sipad.aadba.sgruoruolo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto.TpStfaaForzaArmataDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpSgruoRuoloDTO implements Serializable {

    private static final long serialVersionUID = 5928804091515967361L;

    private String id;
    private String sgruoDescrRuolo;
    private String sgruoDescrbRuolo;
    private String sgruoAcrRuolo;
    private Character sgruoFlagTipo;
    private LocalDate sgruoDataIniz;
    private LocalDate sgruoDataFine;
    private String sgruoCodSipad1;
    private String sgruoCodUid;
    private Character sgruoFlagLiv;
    private Character sgruoFlagAll;
    private Character sgruoFlagRel;
    private Character sgruoFlagEsposiz;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpSgctpCatpersonaleDTO sgruoSgctp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpStfaaForzaArmataDTO sgruoStfaa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpSgruoRuoloDTO sgruoSgruoCod;
}
