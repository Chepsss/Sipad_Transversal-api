package it.almaviva.difesa.sipad.aadba.stproprovincia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.stregregione.dto.TpStregRegioneDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpStproProvinciaDTO implements Serializable {

    private static final long serialVersionUID = -3874464367190495897L;

    private Long id;
    private String stproCodIstat;
    private String stproCodSigla;
    private String stproCDescrProvincia;
    private String stproAcrProvincia;
    private LocalDate stproDataIniz;
    private LocalDate stproDataFine;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpStregRegioneDTO stproStreg;

}
