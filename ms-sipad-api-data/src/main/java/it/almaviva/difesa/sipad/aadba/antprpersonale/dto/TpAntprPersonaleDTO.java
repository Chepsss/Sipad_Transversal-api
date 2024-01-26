package it.almaviva.difesa.sipad.aadba.antprpersonale.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpAntprPersonaleDTO implements Serializable {

    private static final long serialVersionUID = -4046627759592890972L;

    private Long id;
    private String antprDescrTpr;
    private String antprAcrTpr;
    private LocalDate antprDataIniz;
    private LocalDate antprDataFine;
    private Character antprFlagEsposiz;

}
