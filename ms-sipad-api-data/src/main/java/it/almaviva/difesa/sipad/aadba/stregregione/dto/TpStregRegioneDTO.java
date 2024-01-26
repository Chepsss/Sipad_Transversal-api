package it.almaviva.difesa.sipad.aadba.stregregione.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpStregRegioneDTO implements Serializable {

    private static final long serialVersionUID = 5414882880298811556L;

    private Long id;
    private String stregCodRegione;
    private String stregCodIstat;
    private String stregDescrRegione;
    private String stregAcrRegione;
    private LocalDate stregDataIniz;
    private LocalDate stregDataFine;

}
