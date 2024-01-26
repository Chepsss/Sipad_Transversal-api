package it.almaviva.difesa.sipad.aadba.stfaaforzarmata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.antprpersonale.dto.TpAntprPersonaleDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpStfaaForzaArmataDTO implements Serializable {

    private static final long serialVersionUID = 349870485324222841L;

    private String id;
    private String stfaaDescrFfaa;
    private String stfaaAcrFfaa;
    private LocalDate stfaaDataIniz;
    private LocalDate stfaaDataFine;
    private Character stfaaFlagEsposiz;
    private String stfaaCodUid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpStfaaForzaArmataDTO stfaaStfaa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpAntprPersonaleDTO stfaaAntpr;

}
