package it.almaviva.difesa.sipad.aadba.stcomcomune.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.stproprovincia.dto.TpStproProvinciaDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpStcomComuneDTO implements Serializable {

    private static final long serialVersionUID = 8179382486812839469L;

    private Long id;
    private String stcomCodComune;
    private String stcomCodIstat;
    private String stcomDescrComune;
    private String stcomAcrComune;
    private LocalDate stcomDataIniz;
    private LocalDate stcomDataFine;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpStproProvinciaDTO stcomStpro;

}
