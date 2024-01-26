package it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.almaviva.difesa.sipad.aadba.antprpersonale.dto.TpAntprPersonaleDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TpSgctpCatpersonaleDTO implements Serializable {

    private static final long serialVersionUID = 6299470392383292632L;

    private Long id;
    private String sgctpCodCatpers;
    private String sgctpDescrCatpers;
    private String sgctpAcrCatpers;
    private LocalDate sgctpDataIniz;
    private LocalDate sgctpDataFine;
    private Character sgctpFlagEsposiz;
    private String sgctpCodUid;
    private Long sgctpNumOrd;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TpAntprPersonaleDTO sgctpAntpr;

}
