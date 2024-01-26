package it.almaviva.difesa.sipad.aadba.stnaznazione.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpStnazNazioneDTO implements Serializable {

    private static final long serialVersionUID = 6164609639860808801L;

    private Long id;
    private String stnazCodNazione;
    private String stnazCodIstat;
    private String stnazAcrNazione;
    private String stnazDescrNazione;
    private LocalDate stnazDataIniz;
    private LocalDate stnazDataFine;

}
