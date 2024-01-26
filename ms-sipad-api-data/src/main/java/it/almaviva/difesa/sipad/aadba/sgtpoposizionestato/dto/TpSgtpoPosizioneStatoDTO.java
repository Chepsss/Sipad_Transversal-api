package it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto.TpSgctpCatpersonaleDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpSgtpoPosizioneStatoDTO implements Serializable {

    private static final long serialVersionUID = 7495319402519103614L;

    private String id;
    private String sgtpoDescrPosizione;
    private String sgtpoAcrPosizione;
    private LocalDate sgtpoDataIniz;
    private LocalDate sgtpoDataFine;
    private Long sgtpoSgctsId;
    private TpSgctpCatpersonaleDTO sgtpoSgctp;
    private String sgtpoCodSipad1;
    private String sgtpoCodUid;
    private String sgtpoCodConf;
    private Long sgtpoValFermin;
    private Long sgtpoValFermax;
    private String sgtpoFlagProl;
    private Long sgtpoValFeragg;

}
